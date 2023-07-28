impl Solution {
    pub fn create_sorted_array(instructions: Vec<i32>) -> i32 {
        
        let mut fenwick = vec![0; 100001];
        let mut cost = 0;
        for (i, &x) in instructions.iter().enumerate() {
            let left = Self::query(&fenwick, x - 1);
            let right = i - Self::query(&fenwick, x);
            cost += std::cmp::min(left, right);
            cost %= 1000000007;
            Self::update(&mut fenwick, x);
        }
        cost as i32
    }
    
    fn query(fenwick: &Vec<i32>, mut i: i32) -> i32 {
        let mut sum = 0;
        while i > 0 {
            sum += fenwick[i as usize];
            i -= i & -i;
        }
        sum
    }
    
    fn update(fenwick: &mut Vec<i32>, mut i: i32) {
        while i < 100001 {
            fenwick[i as usize] += 1;
            i += i & -i;
        }
    }
}