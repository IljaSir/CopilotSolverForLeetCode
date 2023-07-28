impl Solution {
    pub fn maximum_units(box_types: Vec<Vec<i32>>, truck_size: i32) -> i32 {
        
        let mut box_types = box_types;
        box_types.sort_by(|a, b| b[1].cmp(&a[1]));
        let mut truck_size = truck_size;
        let mut units = 0;
        for box_type in box_types {
            let n = box_type[0];
            let u = box_type[1];
            if truck_size <= n {
                units += truck_size * u;
                break;
            } else {
                units += n * u;
                truck_size -= n;
            }
        }
        units
    }
}