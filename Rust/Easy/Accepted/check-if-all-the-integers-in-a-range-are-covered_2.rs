impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        let mut a = vec![false; 51];
        for r in ranges {
            for i in r[0]..=r[1] {
                a[i as usize] = true;
            }
        }
        for i in left..=right {
            if !a[i as usize] {
                return false;
            }
        }
        true
    }
}