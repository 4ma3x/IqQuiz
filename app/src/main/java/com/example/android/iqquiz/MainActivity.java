package com.example.android.iqquiz;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

public class MainActivity extends AppCompatActivity {

    /******************************************************Variables*************************************************************/
    //-----------Quiz with radio------------//
    int q1R = 0;
    int q2R = 0;
    int q3R = 0;
    int q4R = 0;
    int q5R = 0;
    int q10R = 0;
    //-----------Quiz with checkbox------------//
    int q6C = 0;
    int q7C = 0;
    //-----------Quiz with inputText------------//
    int q8T = 0;
    int q9T = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /******************************************************Header*************************************************************/
        //Set the header to be visible only in Portrait mode
        if(getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().heightPixels) {
            //screen switched to Landscape
        } else {
            //screen switched to Portrait
            //-----------------------------Header-------------------------------//
            tiledHeader(R.drawable.hands_scale, R.id.root_linear, true);
        }

        //===============================================Rules to follow to set the Ids=========================================================//
        //100, 200, 300, etc for Quiz number
        //10, 11, 12, etc for TextView Title
        //20, 21, 22, etc for Question/Image
        //30, 31, 32, etc for subViews or buttons containers
        //40, 41, 42, etc for Chechbox, RadioButton, InputText

        //===============================================================Quiz no1===============================================================//
        //radioAndImage(R.id.scroll_layout, 20, 10, R.drawable.q01_scale, 30,40, 41, 42, 43, 44, "Quiz no. 1");
        radioAndImage("image", "radio", R.id.scroll_layout, 100, 110, R.drawable.q01_scale, 130,
                140, 141, 142, 143, 144,
                "Quiz no. 1", R.color.lightGray,
                "A", "B", "C", "D", "E", "N/A", 1);

        createLine(1000, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Quiz no2===============================================================//
        radioAndImage("image", "radio", R.id.scroll_layout, 200, 210, R.drawable.q02_scale, 230,
                240, 241, 242, 243, 244,
                "Quiz no. 2", R.color.lightGray,
                "A", "B", "C", "D", "E", "N/A", 1);

        createLine(2000, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Quiz no3===============================================================//
        radioAndImage("image", "radio", R.id.scroll_layout, 300, 310, R.drawable.q03_scale, 330,
                340, 341, 342, 343, 344,
                "Quiz no. 3", R.color.lightGray,
                "A", "B", "C", "D", "E", "N/A", 1);

        createLine(3000, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Quiz no4===============================================================//
        radioAndImage("image", "radio", R.id.scroll_layout, 400, 410, R.drawable.q04_scale, 430,
                440, 441, 442, 443, 444,
                "Quiz no. 4", R.color.lightGray,
                "A", "B", "C", "D", "E", "N/A", 1);

        createLine(4000, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Quiz no5===============================================================//
        radioAndImage("text", "radio", R.id.scroll_layout, 500, 510, 501, 530,
                540, 541, 542, 543, 544,
                "Quiz no. 5", R.color.lightGray,
                "-1", "2", "0", "1", "5", "Complete the following series: 1, _, 2, 3, 5,...", 1);

        createLine(5000, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Quiz no6===============================================================//
        radioAndImage("text", "checkbox", R.id.scroll_layout, 600, 610, 601, 630,
                640, 641, 642, 643, 644,
                "Quiz no. 6", Color.WHITE,
                "France", "USA", "Australia", "Africa", "Asia", "Select the continents from the list", 1);

        createLine(6000, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Quiz no7===============================================================//
        radioAndImage("text", "checkbox", R.id.scroll_layout, 700, 710, 701, 730,
                740, 741, 742, 743, 744,
                "Quiz no. 7", Color.WHITE,
                "pig", "fish", "ant", "cat", "owl", "Select the animals that are mammals", 1);

        createLine(7000, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Quiz no8===============================================================//
        radioAndImage("text", "editText", R.id.scroll_layout, 800, 810, 801, 830,
                840, 841, 842, 843, 844,
                "Quiz no. 8", Color.WHITE,
                "", "", "", "", "", "Please enter your email =", 1);

        createLine(8000, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Quiz no9===============================================================//
        radioAndImage("text", "editText", R.id.scroll_layout, 900, 910, 901, 930,
                940, 941, 942, 943, 944,
                "Quiz no. 9", Color.WHITE,
                "", "", "", "", "", "Enter the correct answer: 1+2x20/5 =", 2);

        createLine(9000, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Quiz no10===============================================================//
        radioAndImage("text", "radio", R.id.scroll_layout, 1001, 1010, 1011, 1030,
                1040, 1041, 1042, 1043, 1044,
                "Quiz no. 10", Color.WHITE,
                "<18", "<30", "<40", "40-60", ">60", "Select your age interval", 1);

        createLine(9001, R.id.scroll_layout, ActionBar.LayoutParams.MATCH_PARENT, 4, ContextCompat.getColor(this, R.color.lightGray));

        //===============================================================Summary===============================================================//
        //Create the Submit button
        //int id, int idParrent, String text, int color
        createButton(12345, R.id.scroll_layout, "Submit", Color.WHITE);
        setPadding(12345, 8,2,8,0);
        setMargin(12345, 2, 8, 2, 8);
        //Create the text to display the result
        createTextViews(12345+1, R.id.scroll_layout, "", Color.CYAN);
        setPadding(12345+1, 8, 8, 8, 8);
        //
        eventListener(12345);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            onRestoreInstanceState(savedInstanceState);
        } else {
            // Probably initialize members with default values for a new instance
            //initCondition();
        }

        //Log.i("wwwwwwwwwwwwwwwww", "false: " + booleanToInt(false) + " | true: " + booleanToInt(true));

    }//EOF onCreate

    public int booleanToInt(boolean var) {
        return (var == false) ? 0 : 1;
    }

    //---------------------------------Save the current state of variables----------------------------------//
    //http://www.techotopia.com/index.php/Saving_and_Restoring_the_User_Interface_State_of_an_Android_Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveVars(outState);
    }

    public void saveVars(Bundle state) {
        //-----------Quiz with radio------------//
        state.putInt("q1R", q1R);
        state.putInt("q2R", q2R);
        state.putInt("q3R", q3R);
        state.putInt("q4R", q4R);
        state.putInt("q5R", q5R);
        state.putInt("q10R", q10R);
        //-----------Quiz with checkbox------------//
        state.putInt("q6C", q6C);
        state.putInt("q7C", q7C);
        //-----------Quiz with inputText------------//
        state.putInt("q8T", q8T);
        state.putInt("q9T", q9T);
        //Submit message
        state.putString("message", message());
        //EditText no8


        //-----------Quiz with radio------------//
        //Q1
        for(int i=140; i<145; i++) { state.putBoolean("q1R" + i, ((RadioButton) findViewById(i)).isChecked()); }
        //Q2
        for(int i=240; i<245; i++) { state.putBoolean("q2R" + i, ((RadioButton) findViewById(i)).isChecked()); }
        //Q3
        for(int i=340; i<345; i++) { state.putBoolean("q3R" + i, ((RadioButton) findViewById(i)).isChecked()); }
        //Q4
        for(int i=440; i<445; i++) { state.putBoolean("q4R" + i, ((RadioButton) findViewById(i)).isChecked()); }
        //Q5
        for(int i=540; i<545; i++) { state.putBoolean("q5R" + i, ((RadioButton) findViewById(i)).isChecked()); }
        //Q10
        for(int i=1040; i<1045; i++) { state.putBoolean("q10R" + i, ((RadioButton) findViewById(i)).isChecked()); }
        //-----------Quiz with checkbox------------//
        //Q6
        for(int i=640; i<645; i++) { state.putBoolean("q6C" + i, ((CheckBox) findViewById(i)).isChecked()); }
        //Q7
        for(int i=740; i<745; i++) { state.putBoolean("q7C" + i, ((CheckBox) findViewById(i)).isChecked()); }
        //-----------Quiz with inputText------------//
        state.putString("q8TString", ((TextView)findViewById(802)).getText().toString());
        state.putString("q9TString", ((TextView)findViewById(902)).getText().toString());

    }

    protected void onRestoreInstanceState(Bundle savedState) {
        restoreVars(savedState);
    }

    public void restoreVars(Bundle state) {
        //-----------Quiz with radio------------//
        q1R = state.getInt("q1R");
        q2R = state.getInt("q2R");
        q3R = state.getInt("q3R");
        q4R = state.getInt("q4R");
        q5R = state.getInt("q5R");
        q10R = state.getInt("q10R");
        //-----------Quiz with checkbox------------//
        q6C = state.getInt("q6C");
        q7C = state.getInt("q7C");
        //-----------Quiz with inputText------------//
        q8T = state.getInt("q8T");
        q9T = state.getInt("q9T");
        //Submit message
        ((TextView)findViewById(12345+1)).setText(state.getString("message"));


        //-----------Quiz with radio------------//
        //Q1
        for(int i=140; i<145; i++) { ((RadioButton) findViewById(i)).setChecked(state.getBoolean("q1R" + i)); }
        //Q2
        for(int i=240; i<245; i++) { ((RadioButton) findViewById(i)).setChecked(state.getBoolean("q2R" + i)); }
        //Q3
        for(int i=340; i<345; i++) { ((RadioButton) findViewById(i)).setChecked(state.getBoolean("q3R" + i)); }
        //Q4
        for(int i=440; i<445; i++) { ((RadioButton) findViewById(i)).setChecked(state.getBoolean("q4R" + i)); }
        //Q5
        for(int i=540; i<545; i++) { ((RadioButton) findViewById(i)).setChecked(state.getBoolean("q5R" + i)); }
        //Q10
        for(int i=1040; i<1045; i++) { ((RadioButton) findViewById(i)).setChecked(state.getBoolean("q10R" + i)); }
        //-----------Quiz with checkbox------------//
        //Q6
        for(int i=640; i<645; i++) { ((CheckBox) findViewById(i)).setChecked(state.getBoolean("q6C" + i)); }
        //Q7
        for(int i=740; i<745; i++) { ((CheckBox) findViewById(i)).setChecked(state.getBoolean("q7C" + i)); }
        //-----------Quiz with inputText------------//
        ((TextView)findViewById(802)).setText(state.getString("q8TString"));
        ((TextView)findViewById(902)).setText(state.getString("q9TString"));

    }


    /******************************************************************Create ViewGroups********************************************************/
    /**
     * Create the item to put in list
     * @param typeOfContent     (String)    This can be "image" or "text" and stands for the Quiz type
     * @param typeOfButtons     (String)    This can be "radio", "checkbox" or "editText" and stands for the type of the Buttons used (none for editText)
     * @param rootLayoutId      (int)       The root layout id
     * @param relativeLayoutId  (int)       The sub-root Layout id (the items from the list)
     * @param quizNId           (int)       The Quiz title id
     * @param imgId             (int)       The content id (image or text). NOTE!!! the EditText has the id = imgId+1
     * @param subViewId         (int)       The id of the Buttons container Layout
     * @param btnAId            (int)       The id of the button A (can have any int value if the typeOfButtons is ediText)
     * @param btnBId            (int)       /---//---/
     * @param btnCId            (int)       /---//---/
     * @param btnDId            (int)       /---//---/
     * @param btnEId            (int)       /---//---/
     * @param quizTitle         (String)    The string value "Quiz no. 1" of the item title
     * @param colorRel          (int)       The background color of the RelativeLayout items container
     * @param btnA              (String)    The string value of button A
     * @param btnB              (String)    /---//---/
     * @param btnC              (String)    /---//---/
     * @param btnD              (String)    /---//---/
     * @param btnE              (String)    /---//---/
     * @param quizText          (String)    The string value of the Quiz text if typeOfContent is "text"
     * @param inputType         (int)       The input type of the EditText; 1 = text, 2 = number
     */
    public void radioAndImage(String typeOfContent, String typeOfButtons, int rootLayoutId, int relativeLayoutId, int quizNId, int imgId, int subViewId,
                              int btnAId, int btnBId, int btnCId, int btnDId, int btnEId,
                              String quizTitle, int colorRel,
                              String btnA, String btnB, String btnC, String btnD, String btnE, String quizText, int inputType) {

        //Create the RelativeLayout container
        //RelativeLayout which include the Title, the Question/Image and the Buttons
        //int id, int idParrent, int width, int height, int color
        createRelativeLayout(relativeLayoutId, rootLayoutId, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, colorRel);
        setMargin(relativeLayoutId, 0, 4, 0, 8);

        //Create the TextView Title
        createTextViews(quizNId, relativeLayoutId, quizTitle, Color.YELLOW);
        alignRelativeLayout(quizNId, 0, 0, 0, 0, 0, 0, 0, 1, 1);
        setPadding(quizNId, 8, 8, 8, 8);
        ((TextView)findViewById(quizNId)).setTypeface(((TextView)findViewById(quizNId)).getTypeface(), Typeface.BOLD);

        //Check if the content is image or text (if text check if it is editText)
        if (typeOfContent == "image") {
            //ImageView Image
            createImageViews(imgId, relativeLayoutId);
            alignRelativeLayout(imgId, quizNId, 0, 0, 0, 0, 0, 0, 0, 1);
            setPadding(imgId, 8, 8, 8, 8);
        } else {
            //TextView Quiz
            createTextViews(imgId, relativeLayoutId, quizText, Color.CYAN);
            alignRelativeLayout(imgId, quizNId, 0, 0, 0, 0, 0, 0, 0, 1);
            setPadding(imgId, 8, 8, 8, 8);

            if(typeOfButtons == "editText") {
                createEditText(imgId+1, relativeLayoutId, "", Color.GRAY, inputType);
                alignRelativeLayout(imgId+1, quizNId, 0, imgId, 0, 0, 0, 0, 0, 0);
                setPadding(imgId, 8, 0,8, 8);
                Log.i("editText", ".................." + (imgId+1));
            }
        }//EOF if image / editText

        //Check if must Add buttons and the type of buttons
        if ((typeOfButtons == "radio") || (typeOfButtons == "checkbox")) {
            //RadioGroup container for the RadioButtons
            //createRadioGroup(subViewId, relativeLayoutId, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, Color.BLACK);
            //alignRelativeLayout(subViewId, imgId, 0, 0, 0, 0, 0, 0, 0, 1);
            //setPadding(subViewId, 8, 8, 8, 8);

            if (typeOfButtons == "radio") {
                createRadioGroup(subViewId, relativeLayoutId, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, Color.BLACK);
                //createRadioButton(id, idOfParrent, textToDisplay, backgroundColor);
                createRadioButton(btnAId, subViewId, btnA, Color.YELLOW);
                createRadioButton(btnBId, subViewId, btnB, Color.BLUE);
                createRadioButton(btnCId, subViewId, btnC, Color.GRAY);
                createRadioButton(btnDId, subViewId, btnD, Color.YELLOW);
                createRadioButton(btnEId, subViewId, btnE, Color.BLUE);
                //Event Listeners
                radioListener(subViewId, btnAId);
                radioListener(subViewId, btnBId);
                radioListener(subViewId, btnCId);
                radioListener(subViewId, btnDId);
                radioListener(subViewId, btnEId);
            } else if(typeOfButtons == "checkbox") {
                if(getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().heightPixels) {
                    //screen switched to Landscape
                    createGridLayout(subViewId, relativeLayoutId, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, Color.BLACK, LinearLayout.HORIZONTAL, 0, 0);
                } else {
                    //screen switched to Portrait
                    createGridLayout(subViewId, relativeLayoutId, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, Color.BLACK, LinearLayout.HORIZONTAL, 3, 0);
                }//EOF if portrait or landscape

                //event listener for checkbox
                //createRadioButton(id, idOfParrent, textToDisplay, backgroundColor);
                createCheckButton(btnAId, subViewId, btnA, Color.YELLOW);
                createCheckButton(btnBId, subViewId, btnB, Color.BLUE);
                createCheckButton(btnCId, subViewId, btnC, Color.GRAY);
                createCheckButton(btnDId, subViewId, btnD, Color.YELLOW);
                createCheckButton(btnEId, subViewId, btnE, Color.BLUE);
                //Event Listeners
                checkboxListener(btnAId);
                checkboxListener(btnBId);
                checkboxListener(btnCId);
                checkboxListener(btnDId);
                checkboxListener(btnEId);
            }//EOF radio / checkbox
            //Alignment and padding for the buttons container
            alignRelativeLayout(subViewId, imgId, 0, 0, 0, 0, 0, 0, 0, 1);
            setPadding(subViewId, 8, 8, 8, 8);

            //set the Padding for the Buttons
            setPadding(btnAId, 0, 0, 4, 0);
            setPadding(btnBId, 0, 0, 4, 0);
            setPadding(btnCId, 0, 0, 4, 0);
            setPadding(btnDId, 0, 0, 4, 0);
            setPadding(btnEId, 0, 0, 4, 0);
            //set the Margins for the Buttons
            setMargin(btnAId, 2, 0, 2, 0);
            setMargin(btnBId, 2, 0, 2, 0);
            setMargin(btnCId, 2, 0, 2, 0);
            setMargin(btnDId, 2, 0, 2, 0);
            setMargin(btnEId, 2, 0, 2, 0);

        }//EOF if Add buttons

    }//EOF radioAndImage


    /************************************************Event Listeners*********************************************/
    //Remove focus from EditText and hide the keyboard
    //https://discussions.udacity.com/t/remove-focus-from-edittext-and-hide-the-keyboard/513324
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }//EOF dispatchTouchEvent

    public void radioListener(int radioGroupId, int radioButtonId) {
        RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupId);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int radioButtonId) {
                //radioButtonId is the RadioButton selected
                //check for radio buttons
                if(questionNoX(1, 1)) { q1R=1; } else { q1R=0; }
                if(questionNoX(2, 5)) { q2R=1; } else { q2R=0; }
                if(questionNoX(3, 5)) { q3R=1; } else { q3R=0; }
                if(questionNoX(4, 5)) { q4R=1; } else { q4R=0; }
                if(questionNoX(5, 4)) { q5R=1; } else { q5R=0; }
                if(questionNoX(10, 1)||
                        questionNoX(10, 2)||
                        questionNoX(10, 3)||
                        questionNoX(10, 4)||
                        questionNoX(10, 5)) { q10R=1; } else { q10R=0; }

                //Log.i("radiouri", "casetofonul no: " + radioButtonId + " q = " + q7C + " | " + questionNoX(7, 1));
                //Log.i("radiouri", "casetofonul no: " + radioGroup.getId());
            }//EOF onCheckedChanged
        }//EOF OnCheckedChangeListener
        );//EOF setOnCheckedChangeListener
    }//EOF radioListener

    public void checkboxListener(int checkboxId) {
        CheckBox buttonView = findViewById(checkboxId);
        buttonView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //check for checkbox buttons
                if(questionNoX(6, 3)&&
                        questionNoX(6, 4)&&
                        questionNoX(6, 5)) { q6C=1; } else { q6C=0; }
                if(questionNoX(7, 1)&&
                        questionNoX(7, 4)) { q7C=1; } else { q7C=0; }

                //Log.i("un sacaz la tava", "checkboxId: " + buttonView.getId());
            }//EOF onCheckedChanged
        }//EOF OnCheckedChangeListener
        );//EOF setOnCheckedChangeListener
    }//EOF checkboxListener

    /**
     * Check if the buttons are checked     !!!See the above rules to how the buttons ids are set
     * @param question          (int)       This must be completed with the question number (1, 2, 3, etc)
     * @param questionOption    (int)       This stands for the button order (1, 2, 3, etc)
     * @return                  (boolean)   Returns true if button is checked and false if not
     */
    public boolean questionNoX(int question, int questionOption) {
        int questioNumber = question*100+39; //see rules
        //
        if(((CompoundButton)findViewById(questioNumber+questionOption)).isChecked()) {
            //RadioButton & Checkbox extends CompoundButton
            return true;
        }
        return false;
    }

    public void eventListener(int id) {
        //NumbersClickListener clickListener = new NumbersClickListener();

        Button buttonView = (Button) findViewById(12345);

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                if(inputMessage(802, "")) { q8T = 1; } else { q8T = 0; }
                if(inputMessage(902, "9")) { q9T = 1; } else { q9T = 0; }
                //
                if((q1R+q2R+q3R+q4R+q5R+q6C+q7C+q8T+q9T+q10R)!=0) {
                    //displayMessage(message(), 12345 + 1);
                    String email = ((EditText)findViewById(802)).getText().toString();
                    if(isEmailValid(email)==true) {
                        composeEmail(new String[]{email}, "IqQuiz Result", message());
                    } else {
                        Toast.makeText(getApplicationContext(),"Please enter valid email address!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"You must at least try to think!", Toast.LENGTH_LONG).show();
                }

            }//EOF onClick
        }//EOF OnClickListener
        ); //EOF setOnClickListener
    }//EOF eventListener

    public static boolean isEmailValid(String email) {
        String mailExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(mailExpression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        //return boolean true for valid and false for invalid email
        return matcher.matches();
    }

    /**
     * Check if the inputText has the correct value
     * @param id
     * @param correct
     * @return
     */
    private boolean inputMessage(int id, String correct) {
        EditText someText = (EditText)findViewById(id);
        //Log.i("==============", "type: " + someText.getInputType());
        //Log.i("==============", "number: " + someText.getText().toString());
        //check if empty
        if(!someText.getText().toString().isEmpty()) {
            //check the type of inputText
            if (someText.getInputType() == 1) {//1 = text, 2 = number
                return true;
            }
            else if ((someText.getInputType() == 2) && (someText.getText().toString().equals(correct))) {
                //in Java if you want to compare String content you use "equals"
                //if you want to compare their pointer you use "=="
                    return true;
                }
                else {
                    //Return false if the inputText is not a number AND gas the correct value
                    return false;
                }
        } //if inputText is empty then
        else {
            //Return false if the inputTextis empty
            return false;
        }
    }//EOF inputMessage

    /**
     * Returns the message to be displayed on Submit
     * @return
     */
    public String message() {
        int totalPoints = q1R+q2R+q3R+q4R+q5R+q6C+q7C+q8T+q9T+q10R;
        String toastMessage = "";
        String message = "";


        message += "\n" + "Quiz no1: " + q1R; //+ " radio";
        message += "\n" + "Quiz no2: " + q2R; //+ " radio";
        message += "\n" + "Quiz no3: " + q3R; //+ " radio";
        message += "\n" + "Quiz no4: " + q4R; //+ " radio";
        message += "\n" + "Quiz no5: " + q5R; //+ " radio";
        message += "\n" + "Quiz no6: " + q6C; //+ " checkbox";
        message += "\n" + "Quiz no7: " + q7C; //+ " checkbox";
        message += "\n" + "Quiz no8: " + q8T; //+ " input";
        message += "\n" + "Quiz no9: " + q9T; //+ " input";
        message += "\n" + "Quiz no10: " + q10R; //+ " radio";
        message += "\n";
        message += "\n" + "Total points: " + totalPoints;

        if(totalPoints > 6) {
            toastMessage = "Congratulation! you are in the best 20% of the people";
            message += "\n";
            message += "\n" + toastMessage;
            Toast.makeText(getApplicationContext(),toastMessage, Toast.LENGTH_LONG).show();
        } else if((totalPoints>0)&&(totalPoints<=6)) {
            toastMessage = "You can do better than that!";
            message += "\n";
            message += "\n" + toastMessage;
            Toast.makeText(getApplicationContext(),toastMessage, Toast.LENGTH_LONG).show();
        }

        return message;
    }

    /**
     * Display the message when Submit button is pressed
     * @param mes
     * @param id
     */
    public void displayMessage(String mes, int id) {
        TextView submitTextView = (TextView) findViewById(12345+1);
        submitTextView.setText(mes);
        //submitTextView.setVisibility(View.INVISIBLE);
    }

    private void composeEmail(String[] addresses, String subject, String txtBody) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, txtBody);

        //prevent the app from crashing if there are no apps that can handle the intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }//End of composeEmail

    /**********************************************************Create Layouts*********************************************/
    public void createRelativeLayout(int id, int idParrent, int width, int height, int color) {
        RelativeLayout rel = new RelativeLayout(getApplicationContext());
        rel.setLayoutParams(new ActionBar.LayoutParams(width, height));//width, int: the height, either WRAP_CONTENT, MATCH_PARENT, or a fixed size in pixels
        rel.setId(id);
        //rel.setBackgroundColor(color);
        ((ViewGroup)findViewById(idParrent)).addView(rel);
        //Log.i("sange", "id relativ: " + rel.getId());
    }//EOF createRelativeLayout

    public void createLinearLayout(int id, int idParrent, int width, int height, int color, int orientation) {
        LinearLayout rel = new LinearLayout(getApplicationContext());
        rel.setLayoutParams(new ActionBar.LayoutParams(width, height));//width, int: the height, either WRAP_CONTENT, MATCH_PARENT, or a fixed size in pixels
        rel.setId(id);
        //rel.setBackgroundColor(color);
        rel.setOrientation(orientation);
        ((ViewGroup)findViewById(idParrent)).addView(rel);
    }//EOF createLinearLayout

    //RadioGroup extends the LinearLayout class
    public void createRadioGroup(int id, int idParrent, int width, int height, int color) {
        RadioGroup rel = new RadioGroup(getApplicationContext());
        rel.setLayoutParams(new ActionBar.LayoutParams(width, height));//width, int: the height, either WRAP_CONTENT, MATCH_PARENT, or a fixed size in pixels
        rel.setId(id);
        //rel.setBackgroundColor(color);
        rel.setOrientation(LinearLayout.HORIZONTAL);
        ((ViewGroup)findViewById(idParrent)).addView(rel);
    }//EOF createRadioGroup

    public void createGridLayout(int id, int idParrent, int width, int height, int color, int orientation, int columns, int rows) {
        GridLayout rel = new GridLayout(getApplicationContext());
        rel.setLayoutParams(new ActionBar.LayoutParams(width, height));//width, int: the height, either WRAP_CONTENT, MATCH_PARENT, or a fixed size in pixels
        rel.setId(id);
        //rel.setBackgroundColor(color);
        rel.setOrientation(orientation);
        if(columns != 0) { rel.setColumnCount(columns); }
        if(rows != 0) { rel.setRowCount(rows); }
        ((ViewGroup)findViewById(idParrent)).addView(rel);
    }//EOF createGridLayout


    /**********************************************************Create Views*********************************************/
    public void createLine(int id, int idParrent, int width, int height, int color) {
        View rel = new View(getApplicationContext());
        rel.setLayoutParams(new ActionBar.LayoutParams(width, height));//width, int: the height, either WRAP_CONTENT, MATCH_PARENT, or a fixed size in pixels
        rel.setId(id);
        rel.setBackgroundColor(color);
        ((ViewGroup)findViewById(idParrent)).addView(rel);
    }//EOF createLine

    public void createTextViews(int id, int idParrent, String text, int color) {
        TextView someText = new TextView(getApplicationContext());
        someText.setText(text);
        someText.setTextColor(Color.BLACK);
        someText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f);//https://developer.android.com/reference/android/util/TypedValue.html
        someText.setId(id);
        //someText.setBackgroundColor(color);
        someText.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));//width, height
        ((ViewGroup) findViewById(idParrent)).addView(someText); //public class RelativeLayout extends ViewGroup
    }//EOF createTextViews

    public void createEditText(int id, int idParrent, String text, int color, int inputType) {
        EditText someText = new EditText(getApplicationContext());
        someText.setText(text);
        someText.setTextColor(Color.BLACK);
        someText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f);//https://developer.android.com/reference/android/util/TypedValue.html
        someText.setMinimumWidth(100);
        someText.setInputType(inputType); //2 = number; 1 = text
        someText.setGravity(Gravity.BOTTOM);
        //https://developer.android.com/reference/android/R.styleable.html#TextView_inputType
        someText.setId(id);
        someText.setBackgroundColor(color);
        someText.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));//width, height
        ((ViewGroup) findViewById(idParrent)).addView(someText); //public class RelativeLayout extends ViewGroup
    }//EOF createEditText

    public void createImageViews(int id, int idParrent) {
        ImageView someText = new ImageView(getApplicationContext());
        someText.setImageResource(id);
        someText.setScaleType(ImageView.ScaleType.FIT_END);
        //https://robots.thoughtbot.com/android-imageview-scaletype-a-visual-guide
        someText.setId(id);
        someText.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));//width, height
        ((ViewGroup) findViewById(idParrent)).addView(someText); //public class RelativeLayout extends ViewGroup
    }//EOF createImageViews

    public void tiledHeader(int id, int idParrent, boolean visible){
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), id);
        //
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bmp);
        bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
        //
        if(visible == true) {
            LinearLayout layout = (LinearLayout) findViewById(idParrent);
            layout.setBackground(bitmapDrawable);
        }
    }//EOF tiledHeader

    //createRadioButton(view id, idOfParrent, textToDisplay, bellow, leftTo, rightTo, marginTop, marginLeft, marginRight);
    public void createRadioButton(int id, int idParrent, String text, int color) {
        RadioButton someText = new RadioButton(getApplicationContext());
        someText.setText(text);
        someText.setTextColor(Color.BLACK);
        someText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f);//https://developer.android.com/reference/android/util/TypedValue.html
        someText.setId(id);
        //someText.setBackgroundColor(color);
        //someText.isChecked();
        //someText.setChecked(true);
        someText.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));//width, height
        ((ViewGroup) findViewById(idParrent)).addView(someText); //public class RelativeLayout extends ViewGroup
        //
        //Log.i("nasol", "parinte: " + someText.getParent());
    }//EOF createRadioButton

    public void createCheckButton(int id, int idParrent, String text, int color) {
        CheckBox someText = new CheckBox(getApplicationContext());
        someText.setText(text);
        someText.setTextColor(Color.BLACK);
        someText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f);//https://developer.android.com/reference/android/util/TypedValue.html
        someText.setId(id);
        //someText.setBackgroundColor(color);
        //someText.isChecked();
        //someText.setChecked(true);
        someText.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));//width, height
        ((ViewGroup) findViewById(idParrent)).addView(someText); //public class RelativeLayout extends ViewGroup
    }//EOF createCheckButton

    public void createButton(int id, int idParrent, String text, int color) {
        Button someText = new Button(getApplicationContext());
        someText.setText(text);
        someText.setTextColor(Color.BLACK);
        someText.setId(id);
        //someText.setBackgroundColor(color);
        someText.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));//width, height
        ((ViewGroup) findViewById(idParrent)).addView(someText); //public class RelativeLayout extends ViewGroup
    }//EOF createButton

    /**********************************************************Set the alignment, margin and padding*********************************************/
    /**
     * Method to align a view inside a RelativeLayout. NOTE!!! see addOrRemoveProperty; you can put the value 0 if not desired
     * @param id                (int)   The id of the view
     * @param belowId           (int)   The id of the Above view
     * @param leftToId          (int)   The id of the Right view
     * @param rightToId         (int)   The id of the Left view
     * @param alignLeftId       (int)   Align view Left edge to left edge of input id
     * @param alignRightId      (int)   Align view Right edge to left edge of input id
     * @param alignParrentLeft  (int)   Align to Left in Parent
     * @param alignParrentRight (int)   Align to Right in Parent
     * @param alignParrentTop   (int)   Align to Top in Parent
     * @param centerHorizontal  (int)   Center horizontal in Parent
     */
    public void alignRelativeLayout(
            int id, int belowId,
            int leftToId, int rightToId, int alignLeftId, int alignRightId,
            int alignParrentLeft, int alignParrentRight, int alignParrentTop, int centerHorizontal) {
        //find view to apply
        View someView = (View)findViewById(id);

        //add or remove layout properties
        addOrRemoveProperty(someView, RelativeLayout.BELOW, belowId);
        addOrRemoveProperty(someView, RelativeLayout.LEFT_OF, leftToId);
        addOrRemoveProperty(someView, RelativeLayout.RIGHT_OF, rightToId);
        addOrRemoveProperty(someView, RelativeLayout.ALIGN_LEFT, alignLeftId);
        addOrRemoveProperty(someView, RelativeLayout.ALIGN_RIGHT, alignRightId);
        addOrRemoveProperty(someView, RelativeLayout.ALIGN_PARENT_LEFT, alignParrentLeft);
        addOrRemoveProperty(someView, RelativeLayout.ALIGN_PARENT_RIGHT, alignParrentRight);
        addOrRemoveProperty(someView, RelativeLayout.ALIGN_PARENT_TOP, alignParrentTop);
        addOrRemoveProperty(someView, RelativeLayout.CENTER_HORIZONTAL, centerHorizontal);
    }//EOF alignRelativeLayout

    /**
     * Add or Remove properties for a RelativeLayout view
     * @param view      (view)  view to apply
     * @param property  (int)   property to apply to view
     * @param flag      (int)   check if property has ti be Added or Removed
     */
    private void addOrRemoveProperty(View view, int property, int flag){
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if(flag != 0){ layoutParams.addRule(property, flag); }
        else { layoutParams.removeRule(property); }
        view.setLayoutParams(layoutParams);
    }//EOF addOrRemoveProperty

    /**
     * Set the margins for a view
     * @param id            (int)   The id fo the view
     * @param marginLeft    (float) The left margin in dp
     * @param marginTop     (float) The top margin in dp
     * @param marginRight   (float) The right margin in dp
     * @param marginBottom  (float) The bottom margin in dp
     */
    public void setMargin(int id, float marginLeft, float marginTop, float marginRight, float marginBottom) { //margins in dp
        View someView = (View)findViewById(id);

        //create layout parameters to apply
        //LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) someView.getLayoutParams();
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) someView.getLayoutParams();

        //convert input dp in pixels
        params.setMargins(
                Math.round(ConvertDpAndPixels.setDpToPixel(marginLeft, this)),
                Math.round(ConvertDpAndPixels.setDpToPixel(marginTop, this)),
                Math.round(ConvertDpAndPixels.setDpToPixel(marginRight, this)),
                Math.round(ConvertDpAndPixels.setDpToPixel(marginBottom, this)));
        //
        someView.setLayoutParams(params);
    }//EOF setMargin

    /**
     * Set the padding for a view
     * @param id            (int)   The id fo the view
     * @param paddingLeft   (float) The left padding in dp
     * @param paddingTop    (float) The top padding in dp
     * @param paddingRight  (float) The right padding in dp
     * @param paddingBottom (float) The bottom padding in dp
     */
    public void setPadding(int id, float paddingLeft, float paddingTop, float paddingRight, float paddingBottom) { //margins in dp
        View someView = (View)findViewById(id);

        //convert input dp in pixels
        someView.setPadding(
                Math.round(ConvertDpAndPixels.setDpToPixel(paddingLeft, this)),
                Math.round(ConvertDpAndPixels.setDpToPixel(paddingTop, this)),
                Math.round(ConvertDpAndPixels.setDpToPixel(paddingRight, this)),
                Math.round(ConvertDpAndPixels.setDpToPixel(paddingBottom, this)));
    }//EOF setPadding

}
