impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        let mut arr = vec![false; 51];
        for range in ranges {
            for i in range[0]..=range[1] {
                arr[i as usize] = true;
            }
        }
        for i in left..=right {
            if !arr[i as usize] {
                return false;
            }
        }
        true
    }
}