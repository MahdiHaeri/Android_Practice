package com.example.recycleview_project.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.recycleview_project.R
import com.example.recycleview_project.models.Category

class CategoryAdapter(val _context: Context, val _categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder:ViewHolder

        if(convertView == null){
            categoryView = LayoutInflater.from(_context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            categoryView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }


        val category = _categories[position]
        val resourceId = _context.resources.getIdentifier(category.image, "drawable", _context.packageName)
        holder.categoryName?.text = category.title
        holder.categoryImage?.setImageResource(resourceId)
        return categoryView
    }

    override fun getItem(postion: Int): Any {
        return _categories[postion]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return _categories.count()
    }

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}