impl Solution {
    pub fn create_sorted_array(instructions: Vec<i32>) -> i32 {
        
        let mut bit = vec![0; 100001];
        let mut res = 0;
        let mut cost = 0;
        for (i, &n) in instructions.iter().enumerate() {
            let left = Self::query(&bit, n-1);
            let right = i - Self::query(&bit, n);
            cost = (cost + std::cmp::min(left, right)) % 1000000007;
            Self::update(&mut bit, n);
            res = (res + cost) % 1000000007;
        }
        res
    }
    
    fn update(bit: &mut Vec<i32>, mut i: i32) {
        while i < bit.len() as i32 {
            bit[i as usize] += 1;
            i += i & -i;
        }
    }
    
    fn query(bit: &Vec<i32>, mut i: i32) -> i32 {
        let mut res = 0;
        while i > 0 {
            res += bit[i as usize];
            i -= i & -i;
        }
        res
    }
}