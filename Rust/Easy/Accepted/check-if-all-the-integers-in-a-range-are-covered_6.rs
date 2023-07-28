impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        let mut arr: [bool; 50] = [false; 50];
        for range in ranges {
            for i in range[0]..=range[1] {
                arr[i as usize - 1] = true;
            }
        }
        for i in left..=right {
            if !arr[i as usize - 1] {
                return false;
            }
        }
        true
    }
}