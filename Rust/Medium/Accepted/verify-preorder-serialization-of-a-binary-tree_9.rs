impl Solution {
    pub fn is_valid_serialization(preorder: String) -> bool {
        

        let mut nodes = preorder.split(',').peekable();
        let mut slots = 1;
        while let Some(node) = nodes.next() {
            if slots == 0 { return false; }
            if node != "#" {
                slots += 1;
            } else {
                slots -= 1;
            }
        }
        slots == 0
    }
}