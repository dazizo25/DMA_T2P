package com.example.dma_t2p.Assignment;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.dma_t2p.Task.TaskRoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Assignment.class}, version = 2, exportSchema = false )
public abstract class AssignmentRoomDatabase extends RoomDatabase {
    public  abstract AssignmentDao assignmentDao();

    private  static volatile AssignmentDao INSTANCE ;

    private  static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AssignmentRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null){
            synchronized (AssignmentRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AssignmentRoomDatabase.class, "assignment_Table").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                AssignmentDao dao = INSTANCE.assignmentDao();
                dao.deleteAll();
                Assignment assignment = new Assignment(
                        "Assignment Name ?",
                        2,
                        "Assignment Status?");
                dao.insert(assignment);
            });
        }
    };
}
