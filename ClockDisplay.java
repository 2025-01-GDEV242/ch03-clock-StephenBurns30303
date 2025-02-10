
/**
 * The ClockDisplay class implements a digital clock display for a
 * American-style 1 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00 am (midnight) to 11:59 pm (one minute before 
 * midnight).
 * 
 * This version requires an internal variable to maintain if it is AM or PM.
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String timeOfDays;
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        timeOfDays="AM";
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String timeOfDay)
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        timeOfDays = timeOfDay;
        setTime(hour, minute, timeOfDay);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) 
        {  // it just rolled over!
            hours.increment();
            
            if(hours.getValue()== 0)
            {
                hours.increment();
            }

        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour, time of day, and
     * minute.
     */
    public void setTime(int hour, int minute, String timeOfDay)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        timeOfDays=timeOfDay;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM:ToD.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + " " + timeOfDays;
    }
}
