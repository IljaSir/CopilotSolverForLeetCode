impl Solution {
    pub fn is_valid_serialization(preorder: String) -> bool {
        

        let mut slots = 1;
        for p in preorder.split(',') {
            if slots == 0 { return false; }
            if p == "#" {
                slots -= 1;
            } else {
                slots += 1;
            }
        }
        slots == 0
    }
}