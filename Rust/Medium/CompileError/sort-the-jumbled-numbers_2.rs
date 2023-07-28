impl Solution {
    pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums: Vec<i32> = nums;
        nums.sort_by(|a, b| {
            let a = a.to_string();
            let b = b.to_string();
            let mut a = a.chars();
            let mut b = b.chars();
            loop {
                let a = match a.next() {
                    Some(c) => c,
                    None => return Ordering::Less,
                };
                let b = match b.next() {
                    Some(c) => c,
                    None => return Ordering::Greater,
                };
                let a = a.to_digit(10).unwrap() as usize;
                let b = b.to_digit(10).unwrap() as usize;
                let a = mapping[a];
                let b = mapping[b];
                if a < b {
                    return Ordering::Less;
                } else if a > b {
                    return Ordering::Greater;
                }
            }
        });
        nums
    }
}