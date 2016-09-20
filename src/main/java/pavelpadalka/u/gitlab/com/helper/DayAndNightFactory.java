package pavelpadalka.u.gitlab.com.helper;

import org.apache.log4j.Logger;
import pavelpadalka.u.gitlab.com.enums.PartsOfDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DayAndNightFactory {

    private static Date morningTimeLimit;
    private static Date dayTimeLimit;
    private static Date eveningTimeLimit;
    private static Date nightTimeLimit;
    private static final Logger log = Logger.getLogger(DayAndNightFactory.class);

    static {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("DayAndNightTimeLimits");

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            morningTimeLimit = dateFormat.parse(resourceBundle.getString("timeLimit.morning"));
            dayTimeLimit     = dateFormat.parse(resourceBundle.getString("timeLimit.day"));
            eveningTimeLimit = dateFormat.parse(resourceBundle.getString("timeLimit.evening"));
            nightTimeLimit   = dateFormat.parse(resourceBundle.getString("timeLimit.night"));
        } catch (ParseException e) {
            log.error("Parse of the time limit exception", e);
            System.exit(0);
        }

    }

    public static Date getTimeLimit(PartsOfDay partsOfDay) {

        Date result = null;

        if (partsOfDay.equals(PartsOfDay.MORNING)) {
            result = morningTimeLimit;
        } else if (partsOfDay.equals(PartsOfDay.DAY)) {
            result = dayTimeLimit;
        } else if (partsOfDay.equals(PartsOfDay.EVENING)) {
            result = eveningTimeLimit;
        } else if (partsOfDay.equals(PartsOfDay.NIGHT)) {
            result = nightTimeLimit;
        }

            return result;

    }

}