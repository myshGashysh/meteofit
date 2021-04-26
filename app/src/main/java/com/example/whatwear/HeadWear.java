package com.example.whatwear;

public class HeadWear
{
    int temperature;
    public String result;
    HeadWear(int temp)
    {
        String res;
        if(temp>25)
        {
            res="cap";
            this.result=res;
        }
        else if(temp<25 && temp>5)
        {
            res="Nothing";
            this.result=res;
        }
        else if(temp<5 && temp>-10)
        {
            res="hat";
            this.result=res;
        } else if(temp<-10)
        {
            res="WarmHat";
            this.result=res;
        }
    }
    public String GetRes()
    {
        return result;
    }

}