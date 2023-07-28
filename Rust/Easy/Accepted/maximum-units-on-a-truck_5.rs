impl Solution {
    pub fn maximum_units(box_types: Vec<Vec<i32>>, truck_size: i32) -> i32 {
        
        let mut truck_size = truck_size;
        let mut box_types = box_types;
        box_types.sort_by(|a, b| b[1].cmp(&a[1]));
        let mut result = 0;
        for box_type in box_types {
            if truck_size == 0 {
                break;
            }
            if truck_size >= box_type[0] {
                result += box_type[0] * box_type[1];
                truck_size -= box_type[0];
            } else {
                result += truck_size * box_type[1];
                truck_size = 0;
            }
        }
        result
    }
}