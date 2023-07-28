impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        let mut list = vec![0; 51];
        for r in ranges {
            list[r[0] as usize] += 1;
            list[r[1] as usize + 1] -= 1;
        }
        let mut count = 0;
        for i in 1..=50 {
            count += list[i];
            if i >= left && i <= right && count == 0 {
                return false;
            }
        }
        return true;
    }
}