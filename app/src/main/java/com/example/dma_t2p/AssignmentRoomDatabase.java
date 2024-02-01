package com.example.dma_t2p;

import static com.example.dma_t2p.TaskRoomDatabase.sRoomDatabaseCallback;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Assignment.class}, version = 1, exportSchema = false )
public abstract class AssignmentRoomDatabase extends RoomDatabase {
    public  abstract AssignmentDao assignmentDao();

    private  static volatile AssignmentDao INSTANCE ;

    private  static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AssignmentRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AssignmentRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(Context.getApplicationContext(), AssignmentRoomDatabase.class, "assignment_Table").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = onCreate(db) -> {
        super.onCreate(db);
        databaseWriteExecutor.execute(() ->{
            AssignmentDao dao = INSTANCE.assignmentDao();
            dao.deleteAll();
            Assignment assignment = new Assignment(



            )
        });

    }

}
