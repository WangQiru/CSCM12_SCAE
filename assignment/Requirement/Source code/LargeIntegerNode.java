public class LargeIntegerNode
{
    public LargeIntegerNode() {
        digit = -999;
    }

    public LargeIntegerNode(int _new_digit) {
        digit = _new_digit;
    }

    public LargeIntegerNode getNext() {
        return next;
    }

    public LargeIntegerNode setNext(LargeIntegerNode a) {
        next = a;
        return next;
    }


    public int getData() {
        return digit;
    }

    public void setData(int _new_digit) {
        digit = _new_digit;
    }

    private LargeIntegerNode next = null;
    private int digit;

}