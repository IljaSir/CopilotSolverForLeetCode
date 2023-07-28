impl Solution {
    pub fn group_the_people(group_sizes: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut groups = vec![];
        let mut group = vec![];
        let mut group_size = 0;
        let mut group_sizes = group_sizes;
        group_sizes.sort();
        for i in 0..group_sizes.len() {
            if group_size != group_sizes[i] {
                if group_size != 0 {
                    groups.push(group);
                }
                group_size = group_sizes[i];
                group = vec![];
            }
            group.push(i as i32);
            if group_size == group.len() as i32 {
                groups.push(group);
                group = vec![];
            }
        }
        groups
    }
}