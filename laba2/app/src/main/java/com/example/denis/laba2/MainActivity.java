package com.example.denis.laba2;

import android.support.v7.app.AppCompatActivity;
	import android.os.Bundle;
    import java.util.HashMap;
 	import java.util.Objects;
    import android.app.Activity;
	import android.view.Menu;
	import android.view.MenuItem;
	import android.view.TextureView;
	import android.view.View;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.SectionIndexer;
	import android.widget.TextView;

        	public class MainActivity extends AppCompatActivity {
	    EditText editText;
	    Double firstValue;
	    Double secondValue;
	    String operation;
        	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
        	        super.onCreate(savedInstanceState);
        	        setContentView(R.layout.activity_main);
        	        editText = (EditText) findViewById(R.id.editText1);

        	    }

        	    public void buttonClick(View view) {
        	        Button button = (Button) view;
        	        switch (button.getText().toString()) {
            	            case "C":
                	                firstValue = null;
                	                secondValue = null;
                	                operation = null;
                	                editText.setText("");
                                break;
            	            case "<-":
                	                String s = editText.getText().toString();
                	                editText.setText(s.substring(0, s.length()-1));
                	                break;
            	            case "+":
                	                firstValue = Double.valueOf(editText.getText().toString());
                	                operation = "+";
                	                editText.setText(editText.getText().toString() + button.getText());
                               break;
            	            case "-":
                	                firstValue = Double.valueOf(editText.getText().toString());
                	                operation = "-";
                	                editText.setText(editText.getText().toString() + button.getText());
                	                break;
            	            case "*":
                	                firstValue = Double.valueOf(editText.getText().toString());
                	                operation = "*";
                	                editText.setText(editText.getText().toString() + button.getText());
                	                break;
            	            case "/":
                	                firstValue = Double.valueOf(editText.getText().toString());
                	                operation = "/";
                	                editText.setText(editText.getText().toString() + button.getText());
                	                break;
            	            case "^":
                	                firstValue = Double.valueOf(editText.getText().toString());
                	                operation = "^";
                	                editText.setText(editText.getText().toString() + button.getText());
                	                break;
            	            case "√":
                	                firstValue = Double.valueOf(editText.getText().toString());
                	                operation = "√";
                	                editText.setText(editText.getText().toString() + button.getText());
                	                break;
            	            case "=":
                	                switch (operation) {
                    	                    case "+":
                        	                        editText.setText(String.valueOf((firstValue + secondValue)));
                        	                        break;
                    	                    case "-":
                        	                        editText.setText(String.valueOf((firstValue - secondValue)));
                        	                        break;
                    	                    case "*":
                        	                        editText.setText(String.valueOf((firstValue * secondValue)));
                        	                        break;
                    	                    case "/":
                        	                        if (secondValue == 0) {
                            	                            editText.setText("Ошибка");
                            	                        } else {
                            	                            String value = String.valueOf((firstValue / secondValue));
                            	                            int pointIndex = value.indexOf('.');
                            	                            editText.setText(value.substring(0,
                                    	                                    Objects.equals(value.substring(0, value.length() - pointIndex), "1") ?
                                            	                                            Objects.equals(value.substring(pointIndex + 1, pointIndex + 2), "0") ?
                                            	                                                    pointIndex : pointIndex +1 : pointIndex + 2));
                            	                        }
                        	                        break;
                    	                    case "^":
                        	                        editText.setText(String.valueOf(Math.round(Math.pow(firstValue, secondValue))));
                        	                        break;
                    	                    case "√":
                        	                        editText.setText(String.valueOf(Math.round(Math.pow(firstValue, (1/secondValue)))));
                        	                        break;
                    	                    default:
                        	                        break;
                    	                }
                	                firstValue = null;
                	                secondValue = null;
                	                operation = null;
                	                break;
            	            default:
                	                if (operation != null) {
                    	                    if (secondValue != null)
                        	                        secondValue =
                            	                                Double.valueOf((String.valueOf(secondValue) + button.getText().toString()));
                    	                    else
                    	                        secondValue =
                            	                                Double.valueOf(button.getText().toString());
                    	                }
                	                editText.setText(editText.getText().toString() + button.getText());
                	                break;
            	        }
	    }
	}