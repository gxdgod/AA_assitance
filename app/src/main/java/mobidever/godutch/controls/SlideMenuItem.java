package mobidever.godutch.controls;

/**
 * Created by leon on 15-11-3.
 */
public class SlideMenuItem {

    private int mItemID;
    private String mTitle;

    public SlideMenuItem(int pItemID, String pTitle)
    {
        mItemID= pItemID;
        mTitle = pTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setItemID(int mItemID) {
        this.mItemID = mItemID;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getItemID() {
        return mItemID;
    }

}
