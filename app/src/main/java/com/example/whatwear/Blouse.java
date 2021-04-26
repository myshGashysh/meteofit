package com.example.whatwear;

public class Blouse
{
public int result;
Blouse(double temp)
{
    temp=temp-273.15;
    int res;
    if(temp>20)
    {
        res=5;
        this.result=res;
    }
    if(temp<20 && temp>10)
    {
        res=4;
        this.result=res;
    }
    else if (temp<10 && temp>0)
    {
        res=3;
        this.result=res;
    }
    else if (temp<0 && temp>-10)
    {
        res=2;
        this.result=res;
    }
    else if(temp<-10 && temp>-20)
    {
        res=1;
        this.result=res;
    }
    else if(temp<-20)
    {
        res=0;
        this.result=res;
    }
}
public int GetResult()
{
    return result;
}
}
