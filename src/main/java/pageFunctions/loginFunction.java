package pageFunctions;


import pageObjects.loginPage;

public class loginFunction  {
    loginPage lof = new loginPage();

    public String checkSuccessLogin() throws InterruptedException {
        lof.checkRunDevice();
        lof.clickSignUp();
        lof.enterContactInfo();
        lof.closeImNotRobot();
        lof.enterOtp("654321");
        return lof.chkLoggedIn();
    }

    public String checkLogOut() throws InterruptedException {
        return lof.chkLogOut();
    }

    public String checkFailedLogIn() throws InterruptedException {
        lof.enterContactInfo();
        lof.closeImNotRobot();
        lof.enterOtp("111111");
        return lof.chkFailedLogIn();
    }
}
