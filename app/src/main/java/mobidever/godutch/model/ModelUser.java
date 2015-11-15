package mobidever.godutch.model;

import java.util.Date;

/**
 * Created by leon on 15-11-14.
 */
public class ModelUser {
    public int getM_UserID() {
        return m_UserID;
    }

    public String getUserName() {
        return m_UserName;
    }

    public Date getCreateDate() {
        return mCreateDate;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setUserID(int pUserID) {
        this.m_UserID = pUserID;
    }

    public void setUserName(String m_UserName) {
        this.m_UserName = m_UserName;
    }

    public void setCreateDate(Date pCreateDate) {
        this.mCreateDate = pCreateDate;
    }

    public void setStatus(int pStatus) {
        this.mStatus = pStatus;
    }

    private int m_UserID;
    private String m_UserName;
    private Date mCreateDate= new Date();
    //o disable 1 enable
    private  int mStatus;
}
