package com.cs665.Framework.dashboards;

import com.cs665.mockDB.Database;

import java.time.LocalDateTime;

/**
 * Created by mburke on 6/11/17.
 */
public abstract class Dashboard {
    private LocalDateTime startTime;
    private Database database;

    public abstract boolean register(Database db);
}
