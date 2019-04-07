package com.github.jefersondeoliveira.paging.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.jefersondeoliveira.paging.R
import com.github.jefersondeoliveira.paging.model.GitRepo
import kotlinx.android.synthetic.main.item.view.*

class GitAdapter : PagedListAdapter<GitRepo, GitAdapter.RepoViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {

        getItem(position)?.let {
            holder.setData(it)
        }

    }

    class RepoViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        fun setData(repo: GitRepo) {

            view.repoName.text = repo.fullName
            view.descriptions.text = repo.description
            view.stars.text = "Stars: ${repo.starts}"
            view.forks.text = "Forks: ${repo.forks}"

        }

    }

    companion object {
        private val REPO_COMPARATOR: DiffUtil.ItemCallback<GitRepo>
                = object : DiffUtil.ItemCallback<GitRepo>(){

            override fun areItemsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean =
                oldItem.fullName == newItem.fullName

            override fun areContentsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean =
                    oldItem == newItem

        }
    }
}