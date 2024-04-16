//  imports 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise extends JFrame{

    public Exercise(){
        JFrame mainFrame = new JFrame("Exercise App");
        setSize(650, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildMainFrame();
        setVisible(true); }

    private double calcBMI(double weight, double height){
        double bmi = 703 * (weight/Math.pow(height,2)); 
        return GuiBuilder.roundToDecmialPlaces(bmi,2); }

    private double calcBFP(double age, double weight, double height, String gender){
        double bmi = calcBMI(weight, height);
        if (gender.equals("Male")){
            double bfp = (1.2 * bmi) + (.23 * age) - 16.2;
            return GuiBuilder.roundToDecmialPlaces(bfp, 2); }
        else{
            double bfp = 1.2 * bmi + .23 * age - 5.4;
            return GuiBuilder.roundToDecmialPlaces(bfp, 2);} }

    private double handleCalBurned(double time, double weight, String exercise){
        double met;
        if (exercise.equals("Walking")){
            met = 3; 
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        else if (exercise.equals("Swimming")){
            met = 4.8;
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        else if (exercise.equals("Jogging")){
            met = 7;
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        else if (exercise.equals("Sprinting")){
            met = 15;
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        else if (exercise.equals("Lifting Weights")){
            met = 3.5;
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        else if (exercise.equals("Yoga")){
            met = 3;
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        else if (exercise.equals("Calisthentics")){
            met = 3.8;
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        else if (exercise.equals("Sex")){
            met = 2.2;
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        else if (exercise.equals("Cleaning")){
            met = 2.8;
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        else if (exercise.equals("Sleeping")){
            met = .95;
            double x = (time * met * weight) / 200;
            x = GuiBuilder.roundToDecmialPlaces(x, 2);
            return x;
        }
        met = 0;
        return met;
    }

    private void buildCalBurnedFrame(){
        getContentPane().removeAll();
        revalidate();
        repaint();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy= 0;

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Calories Burned Calculator");
        Font titleFont = new Font("Arial", Font.BOLD, 20);
        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, gbc);

        JLabel dL = GuiBuilder.makeLabel("Duration: ");
        JLabel hL = GuiBuilder.makeLabel("Hours");
        JLabel mL = GuiBuilder.makeLabel("Minutes");

        JTextField mT = GuiBuilder.makeTextField(5);
        JTextField hrT = GuiBuilder.makeTextField(5);

        JLabel wL = GuiBuilder.makeLabel("Body Weight: ");
        JTextField wT = GuiBuilder.makeTextField(5);

        String[] genderOptions = {"--Select One--", "pounds", "kilograms"};
        JComboBox<String> weightchoice = new JComboBox<>(genderOptions);

        JLabel catL = GuiBuilder.makeLabel("Select a category:");
        String[] cat = {"--Select One--", "Walking", "Swimming", "Jogging", "Springing", "Lifting Weights", "Yoga", "Calisthentics", "Sex", "Sleeping"};
        JComboBox<String> catChoice =(new JComboBox<>(cat));
        
        JButton calcButton = new JButton("Calculate");
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Getting the mintues from text fields 
                String mTxt = mT.getText();
                Double min = Double.parseDouble(mTxt);

                String hTxt = hrT.getText();
                double hours;
                if (hTxt.isEmpty()) {
                    // If hours text is empty, default to 0 hours
                    hours = 0;
                } else {
                    hours = Double.parseDouble(hTxt);
                }

                double minutes = (hours*(60) + min);
        
                String wTxt = wT.getText();
                String lbsOrKgs = (String) weightchoice.getSelectedItem();
                double weight;
                if (lbsOrKgs.equals("pounds")){
                    double w = Double.parseDouble(wTxt);
                    weight = 2.205 * w;}
                else{
                weight = Double.parseDouble(wTxt);}

                String actChoice = (String) catChoice.getSelectedItem();
            
                double calsBurned = handleCalBurned(minutes,  weight, actChoice);
                String analysis = "";

                CustomDialog customDialog = new CustomDialog(Exercise.this, "Calories Burned Result", "Amount of Calories burned: " + calsBurned + ".", analysis);
                customDialog.setVisible(true);
            }
        });
        //  adding components using grid 
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.gridx= 0;
        gbc.gridy=1;
        add(catL, gbc);

        gbc.gridx=1;  // this is the spot for the first radio button NOTE
        add(catChoice, gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        add(dL, gbc);

        gbc.gridy=3;
        add(hL, gbc);

        gbc.gridx=1;
        add(hrT, gbc);

        gbc.gridy=4;
        add(mT, gbc);

        gbc.gridx=0;
        add(mL, gbc);

        gbc.gridy=5;
        add(wL, gbc);

        gbc.gridx=1;
        add(wT, gbc);

        gbc.gridx = 0;
        gbc.gridy=6;
        add(calcButton,gbc);

        setVisible(true);

    }

    private void buildBMIFrame(){
        getContentPane().removeAll();
        revalidate();
        repaint();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy= 0;

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Body Mass Index Calculator");
        Font titleFont = new Font("Arial", Font.BOLD, 20);
        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, gbc);

        JLabel hL = GuiBuilder.makeLabel("Enter your height(inches):");
        JLabel wL = GuiBuilder.makeLabel("Enter your weight(lbs):");

        JTextField hT = GuiBuilder.makeTextField(5);
        JTextField wT = GuiBuilder.makeTextField(5);

        JButton calcB = GuiBuilder.makeButton("Calculate");
        calcB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                String hTxt = hT.getText();
                double height = Double.parseDouble(hTxt);

                String wTxt = wT.getText();
                double weight = Double.parseDouble(wTxt);
            
                double bmi = calcBMI(weight, height);
                String analysis;

                if (bmi > 0 && bmi <= 18.5)
                    analysis = "You are underweight!";
                else if (bmi >18.5 && bmi<=25)
                    analysis = "You are at a healthy weight!";
                else if (bmi>25 && bmi<=30)
                    analysis = "You are overweight!";
                else if (bmi>30 && bmi<=35)
                    analysis = "You are in Obese Class 1 in terms of BMI.";
                else if (bmi>35 && bmi<=40)
                    analysis = "You are in Obese Class 2 in terms of BMI.";
                else
                    analysis = "You are in Obese Class 3 in terms of BMI.";
        
                //JOptionPane.showMessageDialog(null, "Body Mass Index: " + bmi + "kg/m^2 \n" + analysis);
                CustomDialog customDialog = new CustomDialog(Exercise.this, "BMI Result", "Body Mass Index: " + bmi + "kg/m^2.", analysis);
                customDialog.setVisible(true);
            }
             });
        //  adding components 
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(hL, gbc);

        gbc.gridy = 2;
        add(wL, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(hT, gbc);

        gbc.gridy =2;
        add(wT, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(calcB, gbc);

        setVisible(true);  
    }

    private void buildBFPFrame(){
        //  remove current frame components
        getContentPane().removeAll();

        //  update the frame 
        revalidate();

        //  call to the updating of the frame
        repaint();

        //  setting to a grid bag layout for more control 
        setLayout(new GridBagLayout());

        //  grid bag constraints obj 
        GridBagConstraints gbc = new GridBagConstraints();

        //  setting inital grid x and y 
        gbc.gridx = 0;
        gbc.gridy = 0;

        //  components will stretch to take up the whole row 
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        //  components will be centered in their row, column placement 
        gbc.anchor = GridBagConstraints.CENTER;

        //  set labels for BFP Page
        JLabel titleLabel = new JLabel("Body Fat Percent Calculator");
        Font titleFont = new Font("Arial", Font.BOLD, 20);
        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, gbc);

        JLabel ageL = GuiBuilder.makeLabel("Enter your age:");
        JLabel hL = GuiBuilder.makeLabel("Enter your height(inches):");
        JLabel wL = GuiBuilder.makeLabel("Enter your weight(lbs):");
        JLabel gL = GuiBuilder.makeLabel("Select your gender:");
        
        JTextField ageT = GuiBuilder.makeTextField(5);
        JTextField hT = GuiBuilder.makeTextField(5);
        JTextField wT = GuiBuilder.makeTextField(5);

        //  making drop down menu for gender 
        String[] genderOptions = {"", "Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);
        
        JButton calcB = GuiBuilder.makeButton("Calculate");
        calcB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String ageTxt = ageT.getText();
                double age = Double.parseDouble(ageTxt);

                String hTxt = hT.getText();
                double height = Double.parseDouble(hTxt);

                String wTxt = wT.getText();
                double weight = Double.parseDouble(wTxt);

                String gender = (String) genderComboBox.getSelectedItem();
            
                double bfp = calcBFP(age, weight, height, gender);

                String analysis;

                if (bfp<0 && bfp>2)
                    analysis = "Critically low bodyfat levels.";
                else if (bfp<2 && bfp>6)
                    analysis = "This is the essential level of body fat.";
                else if (bfp>6 && bfp<14)
                    analysis = "This is the typical level of athetles for bodyfat.";
                else if (bfp>14 && bfp<18)
                    analysis = "This is the typical level of fitness atheltes for bodyfat.";
                else if (bfp>18 && bfp<25)
                    analysis = "This is the average level of bodyfat.";
                else 
                    analysis = "This is the obese level of bodyfat.";
            
                CustomDialog customDialog = new CustomDialog(Exercise.this, "Body Fat Percentage Reult", "Your body fat percentage is:" + bfp + "%.", analysis);
                customDialog.setVisible(true);
            }
             });

        //  Adding components 
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(ageL, gbc);

        gbc.gridy = 2;
        add(hL, gbc);
        
        gbc.gridy = 3;
        add(wL, gbc);

        gbc.gridy = 4;
        add(gL, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(ageT, gbc);

        gbc.gridy =2;
        add(hT, gbc);

        gbc.gridy =3;
        add(wT, gbc);

        gbc.gridy=4;
        add(genderComboBox, gbc);

        gbc.gridy=5;
        gbc.gridx=0;
        add(calcB, gbc);

        setVisible(true);
    }

    private double handleMacroCalc(double age, double height, double weight, String activeLvl, String goal, String[] activeChoice, String[] goalChoice){
        //  Goal initialization 
        double goals;
        
        
        if (activeLvl.equalsIgnoreCase(activeChoice[1])){
            double bmr = 10*weight + 6.25*height - 5*age - 5;
            if (goal.trim().equalsIgnoreCase("Extreme Weight loss - 2lbs/week")){
                return bmr - 500;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Loss - 1lb/week")){
                return bmr - 300;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Loss - .5lbs/week")){
                return bmr - 150;

            }
            else if (goal.trim().equalsIgnoreCase("Maintain Weight")){
                return bmr;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Gain - +.5lbs/week")){
                return bmr + 150;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Gain - +1lb/week")){
                return bmr + 300;

            }
            else if (goal.trim().equalsIgnoreCase("Extreme Weight Gain - +2lbs/week")){
                return bmr +500;

            }
        }

        else if (activeLvl.equalsIgnoreCase(activeChoice[2])){
            double bmr = 10*weight + 6.25*height - 5*age - 5;
            goals = bmr*1.19;
            if (goal.trim().equalsIgnoreCase("Extreme Weight loss - 2lbs/week")){
                return goals-500;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Loss - 1lb/week")){
                return goals -300;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Loss - .5lbs/week")){
                return goals -150;

            }
            else if (goal.trim().equalsIgnoreCase("Maintain Weight")){
                return goals;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Gain - +.5lbs/week")){
                return goals+150;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Gain - +1lb/week")){
                return goals+300;

            }
            else if (goal.trim().equalsIgnoreCase("Extreme Weight Gain - +2lbs/week")){
                return goals+500;

            }

        }
        else if (activeLvl.equalsIgnoreCase(activeChoice[3])){
            double bmr = 10*weight + 6.25*height - 5*age - 5;
            goals = bmr*1.375;
            if (goal.trim().equalsIgnoreCase("Extreme Weight loss - 2lbs/week")){
                return goals-500;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Loss - 1lb/week")){
                return goals -300;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Loss - .5lbs/week")){
                return goals -150;

            }
            else if (goal.trim().equalsIgnoreCase("Maintain Weight")){
                return goals;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Gain - +.5lbs/week")){
                return goals+150;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Gain - +1lb/week")){
                return goals+300;

            }
            else if (goal.trim().equalsIgnoreCase("Extreme Weight Gain - +2lbs/week")){
                return goals+500;

            }
        }
        else if (activeLvl.equalsIgnoreCase(activeChoice[4])){
            double bmr = 10*weight + 6.25*height - 5*age - 5;
            goals = bmr*1.465;
            if (goal.trim().equalsIgnoreCase("Extreme Weight loss - 2lbs/week")){
                return goals-500;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Loss - 1lb/week")){
                return goals -300;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Loss - .5lbs/week")){
                return goals -150;

            }
            else if (goal.trim().equalsIgnoreCase("Maintain Weight")){
                return goals;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Gain - +.5lbs/week")){
                return goals+150;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Gain - +1lb/week")){
                return goals+300;

            }
            else if (goal.trim().equalsIgnoreCase("Extreme Weight Gain - +2lbs/week")){
                return goals+500;

            }
        }
        else if (activeLvl.equalsIgnoreCase(activeChoice[5])){
            double bmr = 10*weight + 6.25*height - 5*age - 5;
            goals = bmr*1.55;
            if (goal.trim().equalsIgnoreCase("Extreme Weight loss - 2lbs/week")){
                return goals-500;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Loss - 1lb/week")){
                return goals -300;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Loss - .5lbs/week")){
                return goals -150;

            }
            else if (goal.trim().equalsIgnoreCase("Maintain Weight")){
                return goals;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Gain - +.5lbs/week")){
                return goals+150;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Gain - +1lb/week")){
                return goals+300;

            }
            else if (goal.trim().equalsIgnoreCase("Extreme Weight Gain - +2lbs/week")){
                return goals+500;

            }
        }
        else if (activeLvl.equalsIgnoreCase(activeChoice[6])){
            double bmr = 10*weight + 6.25*height - 5*age - 5;
            goals = bmr*1.725;
            if (goal.trim().equalsIgnoreCase("Extreme Weight loss - 2lbs/week")){
                return goals-500;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Loss - 1lb/week")){
                return goals -300;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Loss - .5lbs/week")){
                return goals -150;

            }
            else if (goal.trim().equalsIgnoreCase("Maintain Weight")){
                return goals;

            }
            else if (goal.trim().equalsIgnoreCase("Mild Weight Gain - +.5lbs/week")){
                return goals+150;

            }
            else if (goal.trim().equalsIgnoreCase("Weight Gain - +1lb/week")){
                return goals+300;

            }
            else if (goal.trim().equalsIgnoreCase("Extreme Weight Gain - +2lbs/week")){
                return goals+500;

            }
        } 
        return 0.0;
    }

    private void buildMacroFrame(){
        getContentPane().removeAll();
        revalidate();
        repaint();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy =0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Macro Calculator");
        Font titleFont = new Font("Arial", Font.BOLD, 20);
    
        // making components
        JLabel aL = GuiBuilder.makeLabel("Age(18-65): ");
        JTextField aTF = GuiBuilder.makeTextField(5);

        String[] genderOptions = {"--Select One--", "Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);

        JLabel wL = GuiBuilder.makeLabel("Enter your weight in pounds(lbs): ");
        JTextField wT = GuiBuilder.makeTextField(5);

        JLabel hL = GuiBuilder.makeLabel("Enter your height in inches(in): ");
        JTextField hT = GuiBuilder.makeTextField(5);

        String[] activityChoice = {"--Select One--", "BMR - Basic Metabolic Rate", "Senditary - Little to no exercise", "Light Activity - Exercise 1-3 times a week", "Moderate Activity - Exercise 4-5 times a week", "Active Activity - Exercise 3-4 times a week", "Very Active Activity - Exercise 4/5 times a week", "Extra Active - Intense exercise daily or intense physical job"};
        JComboBox<String> activeChoice = new JComboBox<>(activityChoice);

        String[] goalOptions = {"--Select One--", "Extreme Weight loss - 2lbs/week", "Weight Loss - 1lb/week", "Mild Weight Loss - .5lbs/week", "Maintain Weight", "Mild Weight Gain - +.5lbs/week", "Weight Gain - +1lb/week", "Extreme Weight Gain - +2lbs/week"};
        JComboBox<String> goalChoice = new JComboBox<>(goalOptions);

        JButton calcButton = GuiBuilder.makeButton("Calculate");
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // getting values from components
                String ageTxt = aTF.getText();
                Double age = Double.parseDouble(ageTxt);

                String heightTxt = hT.getText();
                Double height = Double.parseDouble(heightTxt);

                String weightTxt = wT.getText();
                Double weight = Double.parseDouble(weightTxt);

                String activeLvl = (String) activeChoice.getSelectedItem();

                String goal = (String) goalChoice.getSelectedItem();

                double totalCal = handleMacroCalc(age, height, weight, activeLvl, goal, activityChoice, goalOptions);
                double totalCals = GuiBuilder.roundToDecmialPlaces(totalCal, 0);

                double p = (totalCals * .325) / 4;
                double protein = GuiBuilder.roundToDecmialPlaces(p, 0);

                double c = (totalCals * .4) / 4;
                double carbs = GuiBuilder.roundToDecmialPlaces(c, 0);

                double f = (totalCals * .275) / 9;
                double fat = GuiBuilder.roundToDecmialPlaces(f, 0);

                String analysis = "Your total amount of calories needed: " + totalCals + ".";

                CustomDialog customDialog = new CustomDialog(Exercise.this, "Calorie and Macro Result", "Your recommended macros are: Protein: " + protein + " grams. Carbohydrates: " + carbs + " grams. Fats: " + fat + " grams.", analysis );
                customDialog.setVisible(true);  
            }    
        });

        // adding components

        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, gbc);
        
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(hL, gbc);

        gbc.gridy = 2;
        add(aL, gbc);

        gbc.gridy = 3;
        add(wL, gbc);

        gbc.gridy = 4;
        add(activeChoice, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 5;
        add(goalChoice, gbc);

        gbc.gridy = 6;
        add(calcButton, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;

        gbc.gridy = 1;
        add(hT, gbc);

        gbc.gridy = 2;
        add(aTF, gbc);

        gbc.gridy = 3;
        add(wT, gbc);

      
        setVisible(true);
    }

    private void buildMainFrame(){
        getContentPane().removeAll();
        revalidate();
        repaint();

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Nutrition App");
        Font titleFont = new Font("Arial", Font.BOLD, 20);
        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, gbc);

        // Button for home page
        JButton bfpButton = GuiBuilder.makeButton("Click here for BFP Calcuator");
        bfpButton.addActionListener(e -> buildBFPFrame());

        JButton bmiButton = GuiBuilder.makeButton("Click here for BMI Calculator");
        bmiButton.addActionListener(e -> buildBMIFrame());

        JButton calButton = GuiBuilder.makeButton("Click here for Cals Burned Calculator");
        calButton.addActionListener(e -> buildCalBurnedFrame());

        JButton macroButton = GuiBuilder.makeButton("Click here for Macro Calculator");
        macroButton.addActionListener(e -> buildMacroFrame());

        // Making menu uses lambda(->) to call functions I want on click of button
        JMenuBar menuBar = new JMenuBar();
        JMenu calcs = new JMenu("Calculators");

        JMenuItem homeItem = new JMenuItem("Home Page");
        homeItem.addActionListener(e -> buildMainFrame());

        JMenuItem bfpItem = new JMenuItem("BFP Calculator");
        bfpItem.addActionListener(e -> buildBFPFrame());

        JMenuItem calItem = new JMenuItem("Calories Burned Calculator");
        calItem.addActionListener(e -> buildCalBurnedFrame());

        JMenuItem macroItem = new JMenuItem("Macro Calculator");
        macroItem.addActionListener(e -> buildMacroFrame());

        JMenuItem bmiItem = new JMenuItem("BMI Calculator");
        bmiItem.addActionListener(e -> buildBMIFrame());

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        calcs.add(homeItem);
        calcs.add(bfpItem);
        calcs.add(bmiItem);
        calcs.add(calItem);
        calcs.add(macroItem);
        calcs.addSeparator();
        calcs.add(exitItem);

        menuBar.add(calcs);
        setJMenuBar(menuBar);


        // adding to the frame 
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy++;
        add(bfpButton, gbc);
        gbc.gridx++;
        add(bmiButton, gbc);
        gbc.gridy++;
        gbc.gridx--;
        add(calButton,gbc);
        gbc.gridx--;
        add(macroButton,gbc);

        setVisible(true);
    }

    public static void main(String[] args){
        new Exercise();
    }

  


 

    
}

