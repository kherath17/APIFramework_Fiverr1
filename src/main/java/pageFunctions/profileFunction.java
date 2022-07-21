package pageFunctions;

import pageObjects.loginPage;
import pageObjects.menuPage;
import pageObjects.profilePage;

public class profileFunction {
    profilePage pop = new profilePage();
    menuPage mep = new menuPage();
    loginPage lof = new loginPage();

    public String checkMyLevel() throws InterruptedException {
        mep.navProfile();
        pop.clkProMenu();
        return pop.chkMyLevel();
    }

    public String checkProfileEdit() throws InterruptedException {
        pop.navBackFromMyLvl();
        pop.clkProMenu();
        pop.navEditPro();
        pop.editStatusPro_1("Test");
        lof.chkLogOut();
        lof.enterContactInfo();
        lof.closeImNotRobot();
        lof.enterOtp("654321");
        mep.navProfile();
        return pop.editStatusPro_2();
    }
    public void resetStatus() throws InterruptedException {
        mep.navProfile();
        mep.clkProMenu();
        mep.navEditPro();
        mep.editStatusPro_1("YOLO");
    }

    public String checkNotifications() throws InterruptedException {
       // pop.navBackFromMyLvl();
        pop.clkProMenu();
        return pop.chkNotifications();
    }

    public String checkInterests() throws InterruptedException {
        pop.navBackFromMyLvl();
        pop.clkProMenu();
        pop.chkPInterest();
        mep.navVideo();
        return mep.getAddedInterestTxt();
    }

    public void resetInterest() throws InterruptedException {
        mep.navProfile();
        mep.clkProMenu();
        mep.chkPInterest();
    }

    public void checkCountry() throws InterruptedException {
        pop.navBackFromMyLvl();
        pop.clkProMenu();
        pop.chkCountry();
    }

    public String checkBlockedUsr() throws InterruptedException {
        this.resetInterest();
        //pop.navBackFromMyLvl();
        mep.navProfile();
        pop.clkProMenu();
        return pop.chkBlockedUsr();
    }

    public String checkLegalInfo() throws InterruptedException {
        pop.navBackFromMyLvl();
        pop.clkProMenu();
        return pop.chkLglInfo();
    }

    public String darkModeActive() throws InterruptedException {
        pop.navBackFromMyLvl();
        pop.clkProMenu();
        return pop.chkDarkMode();
    }

    public void checkChangeLanguage() throws InterruptedException {
        //pop.navBackFromMyLvl();
        //mep.navProfile();
        pop.clkProMenu();
        pop.chkLanguage();
    }


}
