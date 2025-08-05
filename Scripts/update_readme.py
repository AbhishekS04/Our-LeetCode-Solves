#!/usr/bin/env python3
"""
Automatic README Update Script for Our-LeetCode-Solves Repository

This script automatically scans contributor folders and updates the README.md
with current statistics including:
- Total problems solved per contributor
- Problems solved by difficulty level
- Last updated timestamp
- Overall repository statistics

Usage: python Scripts/update_readme.py
"""

import os
import re
import glob
from datetime import datetime
from pathlib import Path

def count_solutions_in_folder(folder_path):
    """Count solution files in a given folder"""
    if not os.path.exists(folder_path):
        return 0
    
    # Count .cpp and .java files
    cpp_files = glob.glob(os.path.join(folder_path, "**/*.cpp"), recursive=True)
    java_files = glob.glob(os.path.join(folder_path, "**/*.java"), recursive=True)
    
    return len(cpp_files) + len(java_files)

def get_contributor_stats():
    """Get statistics for each contributor"""
    contributors = {
        'AbhishekSingh': {'language': 'C++', 'easy': 0, 'medium': 0, 'hard': 0},
        'SnehasishMondal': {'language': 'C++', 'easy': 0, 'medium': 0, 'hard': 0},
        'TusharKantiDey': {'language': 'Java', 'easy': 0, 'medium': 0, 'hard': 0}
    }
    
    for contributor in contributors:
        base_path = contributor
        if os.path.exists(base_path):
            contributors[contributor]['easy'] = count_solutions_in_folder(os.path.join(base_path, 'Easy'))
            contributors[contributor]['medium'] = count_solutions_in_folder(os.path.join(base_path, 'Medium'))
            contributors[contributor]['hard'] = count_solutions_in_folder(os.path.join(base_path, 'Hard'))
    
    return contributors

def calculate_totals(contributors):
    """Calculate total statistics"""
    total_easy = sum(stats['easy'] for stats in contributors.values())
    total_medium = sum(stats['medium'] for stats in contributors.values())
    total_hard = sum(stats['hard'] for stats in contributors.values())
    total_problems = total_easy + total_medium + total_hard
    
    return {
        'total': total_problems,
        'easy': total_easy,
        'medium': total_medium,
        'hard': total_hard
    }

def update_readme():
    """Update the README.md file with current statistics"""
    readme_path = 'README.md'
    
    if not os.path.exists(readme_path):
        print("README.md not found!")
        return
    
    # Get current statistics
    contributors = get_contributor_stats()
    totals = calculate_totals(contributors)
    current_time = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    
    # Read current README
    with open(readme_path, 'r', encoding='utf-8') as f:
        content = f.read()
    
    # Update Current Statistics section
    stats_pattern = r'### Current Statistics\n- \*\*Total Problems Solved\*\*: `\d+`\n- \*\*Easy\*\*: `\d+` \| \*\*Medium\*\*: `\d+` \| \*\*Hard\*\*: `\d+`'
    stats_replacement = f'''### Current Statistics
- **Total Problems Solved**: `{totals['total']}`
- **Easy**: `{totals['easy']}` | **Medium**: `{totals['medium']}` | **Hard**: `{totals['hard']}`'''
    
    content = re.sub(stats_pattern, stats_replacement, content)
    
    # Update Individual Progress table
    table_start = "### Individual Progress"
    table_end = "*Last Updated:"
    
    # Find the table section
    start_idx = content.find(table_start)
    end_idx = content.find(table_end)
    
    if start_idx != -1 and end_idx != -1:
        # Build new table
        new_table = f"""{table_start}
| Contributor | Easy | Medium | Hard | Total |
|-------------|------|--------|------|-------|"""
        
        for name, stats in contributors.items():
            total_for_contributor = stats['easy'] + stats['medium'] + stats['hard']
            display_name = name.replace('Singh', ' Singh').replace('Mondal', ' Mondal').replace('Dey', ' Dey')
            new_table += f"\n| {display_name} | {stats['easy']} | {stats['medium']} | {stats['hard']} | {total_for_contributor} |"
        
        new_table += f"\n\n*Last Updated: {current_time}*"
        
        # Replace the section
        content = content[:start_idx] + new_table + content[end_idx + len("*Last Updated: [Date]*"):]
    
    # Write updated content
    with open(readme_path, 'w', encoding='utf-8') as f:
        f.write(content)
    
    print(f"README.md updated successfully!")
    print(f"Total problems solved: {totals['total']}")
    print(f"Easy: {totals['easy']}, Medium: {totals['medium']}, Hard: {totals['hard']}")
    print(f"Last updated: {current_time}")

if __name__ == "__main__":
    print("🤖 Updating README.md with latest statistics...")
    update_readme()
    print("✅ Update complete!")
