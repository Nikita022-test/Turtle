package com.turtle;

import android.view.*;
import android.content.*;
import android.util.*;
import android.graphics.*;

public abstract class Turtle extends View
{

	private float x;
	private float y;
	private float c;
	private DictionaryT dic;
	private Paint p=new Paint();
	private String l="";

	public Turtle(Context context,AttributeSet attrs){
		super(context,attrs);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		x=0;
		y=0;
		c=0;
		canvas.drawARGB(80,102,204,255);
		p.setColor(Color.RED);
		p.setStrokeWidth(10);
		for(char k:l.toCharArray()){
			rule(k,canvas);
		}
	}

       //Добовление словаря
	public void setDis(DictionaryT d){
		dic=d;
	}
        //Запуск черепахи
	public void start(String key,int n ){
		for(int i=0;i<n;i++){
			String fkey="";
			for(char k:key.toCharArray()){
				fkey+=dic.getRule(k);
			}
			key=fkey;
			fkey="";
		}
		l=key;
		onDraw(new Canvas());
	}
        
        //повернуть черепаху налево
	protected void leftTurn(float c){
		this.c-=c;
	}

        //повернуть черепаху направо
	protected void rightTurn(float c){
		this.c+=c;
	}
         
        //черепаха шагает в перёд остовляя след
	protected void step(Canvas canvas){
		float xS=x;
		float yS=y;
		bounce();
		canvas.drawLine(xS,yS,x,y,p);
	}


        //черепаха шагает в перёд не оставля след
	protected void bounce(){
		x+=Math.cos(Math.toRadians(c))*50;
		y+=Math.sin(Math.toRadians(c))*50;
	}

	protected abstract void rule(char key,Canvas canvas);

}
