# **תרגיל - הוספת דף CRUD לפרויקט `plant_care_2025`**

## **1. הגדרת משתמש ב-Git (אם זו הפעם הראשונה שאתם משתמשים ב-Git)**
לפני השימוש ב-Git, יש להגדיר את השם והאימייל שלכם (נדרש רק בפעם הראשונה):  
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```
בדקו שהפרטים נשמרו כראוי:
```bash
git config --global --list
```

## **2. יצירת Fork והכנת סביבת העבודה**
1. התחברו ל-GitHub וגשו לריפוזיטורי **`yossefavr/plant_care_2025`**.
2. לחצו על **Fork** כדי ליצור עותק אישי של הפרויקט תחת החשבון שלכם.
3. העתיקו את הקישור של ה-`Fork` שלכם.
4. פתחו את `VS Code` או `Eclipse` (או סביבת העבודה שבה אתם עובדים).
5. שיבצו את הפקודה הבאה בטרמינל כדי לשכפל (clone) את ה-`Fork` שלכם למחשב המקומי:
   ```bash
   git clone <your-fork-url>
   ```
6. עברו לתיקיית הפרויקט:
   ```bash
   cd plant_care_2025
   ```
7. הוסיפו את הריפוזיטורי המקורי כ-remote חדש:
   ```bash
   git remote add upstream https://github.com/yossefavr/plant_care_2025.git
   ```
8. ודאו שהרשתם את ה-remote:
   ```bash
   git remote -v
   ```

## **3. יצירת Branch חדש עבור הפיצ'ר שלכם**
```bash
git checkout -b add_crud_<your-name>
```
(החליפו `<your-name>` בשם הפרטי שלכם)

## **4. הוספת דף CRUD לפרויקט**
✅ **אין לשנות את התפריט הראשי!**  
✅ **יש לקרוא לדף שלכם על שם הפרטי שלכם!**  

1. בתוך `src/main/resources/templates` צרו קובץ חדש בשם **`yourname.html`**.
2. הוסיפו טבלה בסיסית ב-Thymeleaf להצגת נתונים.
3. בתוך `src/main/java/com/example/plant_care/controllers`, צרו קובץ חדש בשם **`YourNameController.java`**.
4. מימשו פעולות **CRUD** באמצעות Spring MVC ו-`JPA`.

## **5. Commit & Push לשינויים**
```bash
git status
git add .
git commit -m "Added CRUD page for <your-name>"
git push origin add_crud_<your-name>
```

## **6. פתיחת Pull Request (PR)**
1. היכנסו ל-GitHub ולפרויקט ה-`Forked` שלכם.
2. לחצו על **"Compare & Pull Request"**.
3. כתבו תיאור קצר ושלחו את ה-PR לבדיקה.

✅ **המנחה יבצע את העדכונים בתפריט הראשי לאחר בדיקה!**  

## **7. עדכון מול הריפוזיטורי הראשי**
```bash
git checkout main
git fetch upstream
git merge upstream/main
git checkout add_crud_<your-name>
git merge main
git push origin add_crud_<your-name>
```

✅ אם יש בעיה עם ה-PR, ניתן לערוך את הקוד ולבצע commit נוסף, והוא יתעדכן אוטומטית ב-PR.
