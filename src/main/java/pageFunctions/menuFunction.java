package pageFunctions;

import pageObjects.menuPage;

public class menuFunction {
    menuPage mp = new menuPage();

    public String PageLoad_Profile() throws InterruptedException {
        mp.navProfile();
        return mp.chkProfileLoad();
    }

    public String PageLoad_Explore() throws InterruptedException {
        mp.navExplore();
        return mp.chkExploreLoad();
    }

    public String PageLoad_Media() throws InterruptedException {
        mp.navVideo();
        return mp.chkMediaLoad();
    }
    public String PageLoad_Public() throws InterruptedException {
        mp.navProfile(); //Tetsing by navigatin ack and coming to public

        mp.navPublic();
        return mp.chkPublicLoad();
    }
    public String PageLoad_Private() throws InterruptedException {
        mp.navProfile();
        mp.navPrivate();
        return mp.chkPrivateLoad();
    }
}
