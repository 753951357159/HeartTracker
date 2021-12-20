import java.io.Serializable;

public class Report implements Serializable {

	private static final long serialVersionUID = 2456160310133503475L;
	private DateTime time;
    private int sys;
    private int dia;
    private int pulse;

    public Report(DateTime time, int sys, int dia, int pulse) {
        this.time = time;
        this.sys = sys;
        this.dia = dia;
        this.pulse = pulse;
    }

    public DateTime getTime() {
        return time;
    }

    public int getSys() {
        return sys;
    }

    public int getDia() {
        return dia;
    }

    public int getPulse() {
        return pulse;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public void setSys(int sys) {
        this.sys = sys;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
    
    @Override
    public String toString() {
		return String.format("%-35sSYS: %-20s DIA: %-20s PULSE: %s", this.time, this.sys, this.dia, this.pulse);
    }
}
