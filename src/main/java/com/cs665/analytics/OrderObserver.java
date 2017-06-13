package com.cs665.analytics;

import com.cs665.Framework.dashboards.Observer;

/**
 * Created by mburke on 5/31/17.
 */
public interface OrderObserver extends Observer {
    void update();
}
