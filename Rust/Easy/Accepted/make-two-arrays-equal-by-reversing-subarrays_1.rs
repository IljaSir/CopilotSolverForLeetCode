impl Solution {
    pub fn can_be_equal(target: Vec<i32>, arr: Vec<i32>) -> bool {
        
        let mut target = target;
        let mut arr = arr;
        target.sort();
        arr.sort();
        target == arr
    }
}