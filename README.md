# Flock | HackMIT 2022
## Elevate your lifestyle
Flock is an app where the user tracks meals throughout the day by taking pictures. The AI model evaluates calories and micronutrients, allowing users to journal and elevate their lifestyle. Users can receive meal recommendations, and integrate their account with our industry partners in meal prep delivery. 

## How does Flock work?
With our backend ML model, after scanning the respective food with your camera, our script scours our cloud database of nutritional information for a variety of foods. Once a match is made, the respective information (calories, fats, sugar, etc.) is returned to the user. Flock also allows users to journal down the different foods that they consume on a daily basis, see summaries of past logs... truly allowing for a healthy lifestlye to be accessible by everyone.

## How can I run the app?
1. Clone the git repository.
2. Open in Android Studio.
3. Run the application.

## How can I train the model?
1. Download the food 101 dataset at https://data.vision.ee.ethz.ch/cvl/datasets_extra/food-101/.
2. Unzip the file into the image_classifier folder.
3. In data.py, replace food_list with desired foods to train the model on.
4. Run `python data.py` to prepare the data.
5. Run `python train.py` to train the model.
6. In infer.py, replace guac.jpg with desired inference input image.
7. Run `python infer.py` to generate the inference output image.

#### *We are currently still in development but look out for new features such as being able to connect & share with friends, as well as directly order from our partners!

### Built with: 
* Python
* Tensorflow
* Java
* Android Studio
* InterSystems
