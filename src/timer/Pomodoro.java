/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

/**
 *
 * @author blago
 */
public class Pomodoro {
    private int timerSeconds;

    public int getTimerSeconds() {
        return timerSeconds;
    }

    public void setTimerSeconds(int timerSeconds) {
        this.timerSeconds = timerSeconds;
    }
    
    public Pomodoro(int minutes) throws InterruptedException {
        setTimerSeconds(toSeconds(minutes));
        
        for (int i = 0; i < toSeconds(minutes); i++) {
            Thread.sleep(1000);
            printTimer();
            tickSecond(-1);
        }
    }

    private int toSeconds(int minutes) {
        return minutes * 60;
    }

    private void printTimer() {
        int seconds = getTimerSeconds() % 60;
        int minutes = (getTimerSeconds() - seconds) / 60;
        
        System.out.println("Minutes: " + minutes + " Seconds: " + seconds);
    }

    private void tickSecond(int i) {
        int timer = getTimerSeconds();
        setTimerSeconds(timer + i);
    }
    
}
