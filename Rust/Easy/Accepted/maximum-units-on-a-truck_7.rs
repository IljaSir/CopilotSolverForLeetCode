impl Solution {
    pub fn maximum_units(box_types: Vec<Vec<i32>>, truck_size: i32) -> i32 {
        
        let mut box_types = box_types;
        let mut truck_size = truck_size;
        let mut sum = 0;
        box_types.sort_by(|a, b| b[1].cmp(&a[1]));
        for i in 0..box_types.len() {
            let n = box_types[i][0];
            let u = box_types[i][1];
            if n <= truck_size {
                sum += n * u;
                truck_size -= n;
            } else {
                sum += truck_size * u;
                break;
            }
        }
        sum
    }
}