package com.example.kiran.anotherjsonwebservice;

/**
 * Created by Kiran on 04-12-2015.
 */
public class ListData {
    private String title,url,category,tg_1,tg_2,tg_3;
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getTitle()
    {
        return(title);
    }
    public void setUrl(String url)
    {
        this.url=url;
    }
    public String getUrl()
    {
        return(url);
    }
    public void setCategory(String category)
    {
        this.category=category;
    }
    public String getCategory()
    {
        return(category);
    }
    public void settag_1(String tg_1)
    {
        this.tg_1=tg_1;
    }
    public String gettag_1()
    {
        return(tg_1);
    }
    public void settag_2(String tg_2)
    {
        this.tg_2=tg_2;
    }
    public String gettag_2()
    {
        return(tg_2);
    }
    public void settag_3(String tg_3)
    {
        this.tg_3=tg_3;
    }
    public String gettag_3()
    {
        return(tg_3);
    }
}
