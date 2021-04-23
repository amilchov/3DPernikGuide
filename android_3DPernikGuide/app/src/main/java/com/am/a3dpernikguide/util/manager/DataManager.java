package com.am.a3dpernikguide.util.manager;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.R;
import com.am.a3dpernikguide.db.PernikGuideDatabase;
import com.am.a3dpernikguide.model.db.ModelEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class DataManager {

    public enum SIGHTS{MUSEUM, FORTRESS}

    //URL
    public static final String BASE_URL = "https://pernikguide.noit.eu/api/";
    public static final String REGISTER = "register";
    public static final String LOGIN = "login";

    //Global Constants
    public static final String WRONG_ERROR = "Нещо се обърка! Опитайте отново!";
    public static final String WARNING = "Внимание!";
    public static final String ERROR = "Грешка!";
    public static final String REQUIRED_NETWORK = "Необходима е интернет връзка!";
    public static final String OK = "ОК";
    public static final String WAIT = "Моля, изчакайте!";

    //Constants for Registration and Login form
    public static final String SUCCESS_CREATE_USER = "Успешно създадохте профил!";
    public static final String SUCCESS_LOGIN_USER = "Успешно влизане в профила!";
    public static final String EMPTY_FIELD = "Полето е празно!";
    public static final String INVALID_EMAIL = "Невалиден имейл!";
    public static final String EXIST_EMAIL = "Имейлът вече съществува!";
    public static final String PASS_NOT_MATCH = "Паролите не съвпадат!";
    public static final String INVALID_DATA = "Невалидни данни! Опитайте отново!";
    public static final int NAME_FIELD_VALIDATION_NUMBER = 2;
    public static final int PASSWORD_FIELD_VALIDATION_NUMBER = 5;

    //Constants for SharedPreferences
    public static final String PREF_NAME = "User";
    public static final String PREF_NAME_USER_DATA = "user_data";
    public static final String FIRST_NAME = "first_name";
    public static final String SECOND_NAME = "second_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String TOKEN = "token";
    public static final String COUNT_FORTRESS = "count_fortress";
    public static final String LAST_VISIT_FORTRESS = "last_visit_fortress";
    public static final String COUNT_MUSEUM = "count_museum";
    public static final String LAST_VISIT_MUSEUM = "last_visit_museum";

    //Paths for 3D models
    //Fortress
    public static final String CHURCH_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/church.obj";
    public static final String WALL_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/wall.obj";
    public static final String HOUSES_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/houses.obj";
    public static final String BIG_CHURCH_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/big_church.obj";

    //Museum
    public static final String TABLO_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/tablo.obj";
    public static final String POMPA_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/vodnapompa.obj";
    public static final String DROBENE_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/drobene.obj";
    public static final String ELCART_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/elcart.obj";
    public static final String HASPEL_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/makara.obj";
    public static final String VENTILATOR_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/ventilator.obj";
    public static final String HORSE_PATH = "assets://" + "com.am.a3dpernikguide" + "/models/horse.obj";

    //Paths for Pictures
    //Fortress
    public static final String CHURCH_PATH_IMAGE = "android.resource://" + "com.am.a3dpernikguide/" + R.drawable.church;
    public static final String WALL_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/wall";
    public static final String HOUSES_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/houses";
    public static final String BIG_CHURCH_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/big_church";

    //Museum
    public static final String TABLO_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/tablo";
    public static final String POMPA_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/vodnapompa";
    public static final String DROBENE_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/drobene";
    public static final String ELCART_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/elcart";
    public static final String HASPEL_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/makara";
    public static final String VENTILATOR_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/ventilator";
    public static final String HORSE_PATH_IMAGE = "android.resource://"+ "com.am.a3dpernikguide" + "/drawable/horse";



    //Home
    public static final String EMPTY_COUNT = "0";
    public static final String EMPTY_TIME_VISIT = "Няма";


    public static String containingCharacters (int number) {
         return "Полето трябва да съдържа над " + number + " знака!";
    }

    public static void addModelsToDatabase() {
        PernikGuideDatabase database = PernikGuideDatabase.getDatabase(PernikGuideApplication.getContext());

        List<ModelEntry> entries = new ArrayList<>();
        //fortress data
        entries.add(new ModelEntry("Църква №5",
                "Привратна двуетажна църква при северната порта. Намира се на главната улица, като тунел, минаващ под кораба ѝ, разделя приземния етаж на две части: източна - крипта с две гробни камери и западна - със стълбището към етажа. Долният етаж е изграден от ломен камък и хоросанова спойка. Важна особеност на тази църква е, че проходът на долния етаж е насочен необичайно - напречно на оста на сградата, докато при повечето известни надвратни църкви проходите са оставени по надлъжните оси на сградите ( надвратна църква в Киево-Печорска лавра, църквата над \"Златната врата\" в гр. Владимир и др.).  В етажа над приземието е била развита кръстокуполна гробнична църква, имаща план \"стегнат кръст\". Въз основа на архитектурните ѝ особености, тя е датирана към XI-XII в.",
                "aHR&f%A_u5DNmA$r",
                CHURCH_PATH,
                "fortress",
                false,
                CHURCH_PATH_IMAGE));

        entries.add(new ModelEntry("Крепостна стена",
                "Оградени от крепостните стени са били около 50 декара. Каменната стена, обграждаща крепостта, е изградена от две зидарии с ширина 1 м  и върви по естествените очертания на хълма, върху който някога се е разполагал центърът на административна област Перник. Тя е с обща дължина около 800 м. За съжаление при възстановяването на стената, новата зидария е вървяла ту по външната, ту по вътрешната зидария на стената и е загубен уникалният и автентичен изглед на крепостната стена. В североизточната част на крепостта се намира нейната главна порта, зад която започва и основна улица на „града“.",
                "r$sSUmUCvL4yrzTW",
                WALL_PATH,
                "fortress",
                false,
                WALL_PATH_IMAGE));

        entries.add(new ModelEntry("Селище",
                "Няма налична информация!",
                "vYY4L%AgjNfj+Z2u",
                HOUSES_PATH,
                "fortress",
                false,
                HOUSES_PATH_IMAGE));

        entries.add(new ModelEntry("Църква №2",
                "Няма налична информация!",
                "SWa66ne=Mb=!5B5^",
                BIG_CHURCH_PATH,
                "fortress",
                false,
                BIG_CHURCH_PATH_IMAGE));


        //museum data
        entries.add(new ModelEntry("Сигнално табло", "Сигналното табло служи за подаване на сигнали между хаспелистите в двата края на минната изработка. Чрез звуков и светлинен сигнал се предава информация, когато се спускат или изтеглят вагонетки. Четири иззвънявания означават, че в галерията се движат хора. С помощта на сигналното табло операторите на хаспела разменят информация помежду си и осигуряват безопасна работа.", "5$bvZbzEDakKD7wT", TABLO_PATH, "museum", false, TABLO_PATH_IMAGE));
        entries.add(new ModelEntry("Водоотливна помпа", "При подземния добив на въглища се налага изпомпване на събралата се вода извън минните шахти до повърхността. Според дебита на водата се определя моделът на помпата. Водоотливът се осъществява от галерия в галерия до повърхността, или водата се извежда директно на повърхността посредством сондаж.", "j235z-+%URD&pMPz", POMPA_PATH, "museum", false, POMPA_PATH_IMAGE));
        entries.add(new ModelEntry("Проходчески комбайн", "Рудничният комбайн е произведен през 1936 г. Когато се използва комбайн, не е необходимо взривяване и ръчно прокопаване на галерията.. Главата на комбайна руши и изземва пласта, като оформя профила на галерията. Оформената част се укрепва, след това комбайнът продължава работата си.", "8##zcX*#Qu4n-U*x", DROBENE_PATH, "museum", false, DROBENE_PATH_IMAGE));
        entries.add(new ModelEntry("Електролокомотив „Сименс“", "В първите години на въгледобива добитите въглища се изнасят с колички и тарги. По-късно е въведен извозът с коне. През 20-те години на ХХ век в рудниците започват да се използват акумулаторни локомотиви за теглене на вагонетките, с които миньорите слизат в рудника, и за вагонетките с въглища. Електролокомотивът „Сименс“ е произведен през 1925 г. Електро захранването е чрез пантограф. Движи се само в хоризонтални галерии.", "mybU=59T6Q#!p4#F", ELCART_PATH, "museum", false, ELCART_PATH_IMAGE));
        entries.add(new ModelEntry("Рудничен хаспел „Сименс“", "Хаспелът служи за спускане и изтегляне на вагонетки по наклонени галерии. Всеки хаспел има норма – колко вагонетки наведнъж може да тегли.", "CxB7HLV+F82pDYac", HASPEL_PATH, "museum", false, HASPEL_PATH_IMAGE));
        entries.add(new ModelEntry("Вентилатор за местно проветряване", "Вентилаторът се поставя на 30 метра преди галерията, която се прокарва и разсича пласта. Посредством брезентово-гумени вентилационни тръби вентилаторът проветрява галерията. Взима въздух от централната вентилационна система на повърхността. Нагнетява около 250 кубически метра въздух в минута.", "UYK9gqC#Hr^c&85Y", VENTILATOR_PATH, "museum", false, VENTILATOR_PATH_IMAGE));
        entries.add(new ModelEntry("Макет на кон", "Извозът на въглища с коне е въведен през 1896 г. През 1922 г. в пернишките рудници са работили 350 коня, като 2/3 от тях живеят и работят под земята. Един кон може да тегли четири дървени вагонетки, пълни с въглища. През 20-те години на ХХ век конете са заменени с акумулаторни и с електрически локомотиви.", "3Ra5BR*xc2*e&Q8%", HORSE_PATH, "museum", false, HORSE_PATH_IMAGE));

        database.modelDao().insertModels(entries);
    }
}
