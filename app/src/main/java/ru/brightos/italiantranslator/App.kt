package ru.brightos.italiantranslator

import android.app.Application
import ru.brightos.italiantranslator.di.PreferenceRepository
import ru.brightos.italiantranslator.di.Types
import ru.brightos.italiantranslator.di.Word

class App : Application() {
    lateinit var preferenceRepository: PreferenceRepository
    lateinit var list: ArrayList<Word>

    override fun onCreate() {
        super.onCreate()
        preferenceRepository =
            PreferenceRepository(getSharedPreferences("DEFAULT_ITALIAN", MODE_PRIVATE))
        list = arrayListOf(
            Word("https://lovesvet.ru/upload/iblock/07c/07c76d2a5c5e7e6614155e664570ead7.jpg", "стол", "tavolo", Types.HOME),
            Word("https://im0-tub-ru.yandex.net/i?id=578924b0f4d8c543c4ccafd49443ac87&n=13", "стена", "parete", Types.HOME),
            Word("https://im0-tub-ru.yandex.net/i?id=30faebd3f1a2ace50e341b8446332f7a&n=13", "дверь", "porta", Types.HOME),
            Word("https://images.chesscomfiles.com/uploads/v1/user/31900090.80fd001d.1200x1200o.37cc048e5cd5.jpeg", "кошка", "gatta", Types.ANIMALS),
            Word("https://animalsik.com/wp-content/uploads/2016/05/velsh-korgi-5-e1462947298660.jpg", "собака", "cane", Types.ANIMALS),
            Word("https://proprikol.ru/wp-content/uploads/2019/10/smeshnye-kartinki-homyakov-43.jpg", "хомяк", "criceto", Types.ANIMALS),
            Word("https://wild-msk.ru/images/detailed/32/230-170.jpg", "чашка", "tazza", Types.KITCHEN),
            Word("https://images.ru.prom.st/720862348_w640_h640_kastryulya-agness-51l.jpg", "кастрюля", "pentola", Types.KITCHEN),
            Word("https://images.ru.prom.st/560796457_w640_h640_tarelka-melkaya-farfor.jpg", "тарелка", "scodellino", Types.KITCHEN),
            Word("http://4404.ru/sticky-money/lp/img/exe.png", "грусть", "tristezza", Types.EMOTIONS),
            Word("https://youthworkinit.com/wp-content/uploads/2012/06/Youth-ministry-qualifications.jpg", "радость", "gioia", Types.EMOTIONS),
            Word("https://im0-tub-ru.yandex.net/i?id=794ad8e7a560682d843ee03f500c63c6&n=13", "злость", "rabbia", Types.EMOTIONS)
        )
    }
}