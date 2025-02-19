package nya.kitsunyan.foxydroid

import android.content.Intent
import android.content.pm.PackageInstaller
import com.squareup.picasso.BuildConfig
import nya.kitsunyan.foxydroid.screen.ScreenActivity

class MainActivity: ScreenActivity() {
  companion object {
    const val ACTION_UPDATES = "${BuildConfig.APPLICATION_ID}.intent.action.UPDATES"
    const val ACTION_INSTALL = "${BuildConfig.APPLICATION_ID}.intent.action.INSTALL"
    const val EXTRA_CACHE_FILE_NAME = "${BuildConfig.APPLICATION_ID}.intent.extra.CACHE_FILE_NAME"
  }

  override fun handleIntent(intent: Intent?) {
    when (intent?.action) {
      ACTION_UPDATES -> handleSpecialIntent(SpecialIntent.Updates)
      ACTION_INSTALL -> handleSpecialIntent(
        SpecialIntent.Install(
          intent.packageName,
          intent.getIntExtra(PackageInstaller.EXTRA_STATUS, -1),
          intent.getParcelableExtra(Intent.EXTRA_INTENT)
        )
      )
      else -> super.handleIntent(intent)
    }
  }
}
