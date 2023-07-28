impl Solution {
    pub fn group_the_people(group_sizes: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut groups: Vec<Vec<i32>> = vec![];
        let mut group_sizes = group_sizes.clone();
        for (i, &size) in group_sizes.iter().enumerate() {
            if size > 0 {
                let mut group: Vec<i32> = vec![];
                group.push(i as i32);
                group_sizes[i] -= 1;
                for j in i + 1..group_sizes.len() {
                    if group_sizes[j] == size {
                        group.push(j as i32);
                        group_sizes[j] -= 1;
                    }
                    if group.len() == size as usize {
                        break;
                    }
                }
                groups.push(group);
            }
        }
        groups
    }
}