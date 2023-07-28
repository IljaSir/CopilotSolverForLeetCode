impl Solution {
    pub fn maximum_units(box_types: Vec<Vec<i32>>, truck_size: i32) -> i32 {
        
        let mut box_types = box_types;
        box_types.sort_by_key(|x| x[1]);
        let mut truck_size = truck_size;
        let mut total = 0;
        while truck_size > 0 && !box_types.is_empty() {
            let box_type = box_types.pop().unwrap();
            if box_type[0] <= truck_size {
                total += box_type[0] * box_type[1];
                truck_size -= box_type[0];
            } else {
                total += truck_size * box_type[1];
                truck_size = 0;
            }
        }
        total
    }
}