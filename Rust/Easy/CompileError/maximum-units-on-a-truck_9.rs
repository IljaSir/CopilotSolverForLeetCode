impl Solution {
    pub fn maximum_units(box_types: Vec<Vec<i32>>, truck_size: i32) -> i32 {
        
        let mut sorted = box_types.clone();
        sorted.sort_by(|a, b| b[1].cmp(&a[1]));
        let mut count = 0;
        for box_type in sorted {
            let amount = std::cmp::min(box_type[0], truck_size - count);
            count += amount;
            if count == truck_size {
                return count * box_type[1];
            }
        }
        return count * sorted[sorted.len() - 1][1];
    }
}