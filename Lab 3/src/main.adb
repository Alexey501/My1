with Ada.Text_IO, GNAT.Semaphores;
use Ada.Text_IO, GNAT.Semaphores;

with Ada.Containers.Indefinite_Doubly_Linked_Lists;
use Ada.Containers;

procedure Main is
   package String_Lists is new Indefinite_Doubly_Linked_Lists (String);
   use String_Lists;

   procedure Starter (Storage_Size : in Integer; Item_Numbers : in Integer) is
      Storage : List;

      Access_Storage : Counting_Semaphore (1, Default_Ceiling);
      Full_Storage   : Counting_Semaphore (Storage_Size, Default_Ceiling);
      Empty_Storage  : Counting_Semaphore (0, Default_Ceiling);

      task type manufacturer(Item_Numbers : Integer);

      task type Consumer(Item_Numbers : Integer);

      task body manufacturer is
      begin

         for i in 1 .. manufacturer.Item_Numbers loop
            Full_Storage.Seize;
            Access_Storage.Seize;

            Storage.Append ("item " & i'Img);
            Put_Line ("Added item " & i'Img);

            Access_Storage.Release;
            Empty_Storage.Release;
            delay 0.1;
         end loop;

      end manufacturer;

      task body Consumer is
      begin

         for i in 1 .. Consumer.Item_Numbers loop
            Empty_Storage.Seize;
            Access_Storage.Seize;

            declare
               item : String := First_Element (Storage);
            begin
               Put_Line ("Took " & item);
            end;

            Storage.Delete_First;

            Access_Storage.Release;
            Full_Storage.Release;

            delay 0.2;
         end loop;

      end Consumer;

	t1: Consumer (Item_Numbers);
	t2: Consumer (Item_Numbers);
	t3: Consumer (Item_Numbers);
	t4:manufacturer (Item_Numbers);
	t5: manufacturer (Item_Numbers);
	t6: manufacturer (Item_Numbers);

   begin
      null;
   end Starter;

begin
   Starter (2, 6);
   null;
end Main;
