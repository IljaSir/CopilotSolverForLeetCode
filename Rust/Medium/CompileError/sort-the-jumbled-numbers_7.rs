impl Solution {
    pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut mapping = mapping;
        for i in 0..10 {
            mapping[i] += 48;
        }
        nums.sort_by(|x, y| {
            let mut x = x.to_string();
            let mut y = y.to_string();
            let mut x = x.as_bytes_mut();
            let mut y = y.as_bytes_mut();
            for i in 0..x.len() {
                x[i] = mapping[(x[i] - 48) as usize] as u8;
            }
            for i in 0..y.len() {
                y[i] = mapping[(y[i] - 48) as usize] as u8;
            }
            let x = String::from_utf8(x.to_vec()).unwrap();
            let y = String::from_utf8(y.to_vec()).unwrap();
            x.cmp(&y)
        });
        nums
    }
}