impl Solution {
    pub fn can_be_equal(target: Vec<i32>, arr: Vec<i32>) -> bool {
        
        let mut a = arr.clone();
        let mut t = target.clone();
        a.sort();
        t.sort();
        a == t
    }
}