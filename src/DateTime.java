import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime implements Serializable {

	private static final long serialVersionUID = 5674047746282095751L;
	private LocalDateTime time;
    private DayTime category;

    public enum DayTime {
        MORNING("Morning"),
        AFTERNOON("Midday"),
        NIGHT("Night");

        private final String timeLabel;

        DayTime(final String time) {
            this.timeLabel = time;
        }

        public String getTimeLabel() {
            return timeLabel;
        }
    }

    public DateTime(LocalDateTime time) {
        this.time = time;
        this.setCategory();
    }

    public LocalDateTime getTime() {
        return time;
    }

    public DayTime getCategory() {
        return category;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setCategory() {
        if (time.getHour() > 0 && time.getHour() <= 9) {
            this.category = DayTime.MORNING;
        } else if (time.getHour() > 9 && time.getHour() <= 18) {
            this.category = DayTime.AFTERNOON;
        } else {
            this.category = DayTime.NIGHT;
        }
    }

    public String formattedTime() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return time.format(f);
    }
    
    @Override
    public String toString() {
    	return String.format("[%s] %s", this.category, this.formattedTime());
    }
}
