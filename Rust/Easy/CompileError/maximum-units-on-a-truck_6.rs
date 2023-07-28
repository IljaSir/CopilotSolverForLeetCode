impl Solution {
    pub fn maximum_units(box_types: Vec<Vec<i32>>, truck_size: i32) -> i32 {
        
        let mut box_types = box_types;
        box_types.sort_by(|a, b| b[1].cmp(&a[1]));
        let mut res = 0;
        for box_type in box_types {
            let n = box_type[0];
            let u = box_type[1];
            if n <= truck_size {
                res += n * u;
                truck_size -= n;
            } else {
                res += u * truck_size;
                break;
            }
        }
        res
    }
}