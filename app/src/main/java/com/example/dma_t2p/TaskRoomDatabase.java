package com.example.dma_t2p;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Task.class, Assignment.class}, version = 2, exportSchema = false)
public abstract class TaskRoomDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();

    public abstract AssignmentDao assignmentDao();

    private static volatile TaskRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TaskRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TaskRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TaskRoomDatabase.class, "task_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                TaskDao dao = INSTANCE.taskDao();
                dao.deleteAll();
                Task task = new Task(
                        "Task Testing ",
                        1,
                        "2024-01-28",
                        "2024-02-28",
                        123,
                        "Sample Assignment");
                AssignmentDao assignmentDao = INSTANCE.assignmentDao();
                assignmentDao.deleteAll();
                dao.insert(task);
                Assignment assignment = new Assignment(
                        "Assignment Testing",
                        1,
                        "50% complete");
                assignmentDao.insert(assignment);
            });
        }
    };
}
