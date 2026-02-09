package io.legado.app.ui.welcome

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import io.legado.app.R
import io.legado.app.base.BaseFragment
import io.legado.app.databinding.FragmentPrivacyBinding
import io.legado.app.utils.viewbindingdelegate.viewBinding
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrivacyFragment : BaseFragment(R.layout.fragment_privacy) {

    private val binding by viewBinding(FragmentPrivacyBinding::bind)

    override fun onFragmentCreated(view: View, savedInstanceState: Bundle?) {

        viewLifecycleOwner.lifecycleScope.launch {
            val privacyText = withContext(IO) {
                String(requireContext().assets.open("privacyPolicy.md").readBytes())
            }
            val disclaimerText = withContext(IO) {
                String(requireContext().assets.open("disclaimer.md").readBytes())
            }
            binding.tvPrivacy.text = privacyText
            binding.tvDisclaimer.text = disclaimerText
        }

    }

}
