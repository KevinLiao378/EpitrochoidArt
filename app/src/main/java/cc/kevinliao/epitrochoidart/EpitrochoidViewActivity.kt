package cc.kevinliao.epitrochoidart

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_epitrochoid_view.*
import kotlinx.android.synthetic.main.fragment_epitrochoid_view.*

class EpitrochoidViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epitrochoid_view)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().run {
                replace(R.id.fragment, EpitrochoidViewActivityFragment(), TAG)
                commit()
            }
        }

        fab.setOnClickListener { view ->
            val epitrochoidViewActivityFragment = supportFragmentManager.findFragmentByTag(TAG)
            epitrochoidViewActivityFragment.epitrochoidView.reDraw()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_epitrochoid_view, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        val TAG = "EpitrochoidViewActivityFragment"
    }
}
