impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        let mut cover = vec![false; 51];
        for r in ranges.iter() {
            for i in r[0]..(r[1]+1) {
                cover[i as usize] = true;
            }
        }
        for i in left..(right+1) {
            if !cover[i as usize] {
                return false;
            }
        }
        true
    }
}