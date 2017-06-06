package my.spring.test.app.misc;

import java.io.Serializable;

/**
 *
 * Created by Vadym_Yakovlev on 6/1/2017.
 */
public class StatusReport implements Serializable {
    public String getState() {
        return state;
    }

    public void setState(final String stateParam) {
        state = stateParam;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String messageParam) {
        message = messageParam;
    }

    private String state;
   private String message;

   private int activeCount;

    public int getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(final int activeCountParam) {
        activeCount = activeCountParam;
    }
}
